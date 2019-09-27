package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IOrderInfoDao;
import com.maxs.model.OrderInfoModel;

import java.util.List;
import java.util.Map;

public class OrderInfoDaoImpl implements IOrderInfoDao {
    @Override
    public List<Map> getOrderInfo(OrderInfoModel orderInfoModel) {

        String sql = "select * from order_info where order_id = ?";
        Object[] objects = new Object[]{orderInfoModel.getOrderId()};
        return JDBC.excuteQuery(sql,objects);
    }

    @Override
    public int updateGoodsNum(OrderInfoModel orderInfoModel) {

        String sql = "update order_info set num = ? , update_time = ? where order_info_id = ?";
        Object[] objects = new Object[]{orderInfoModel.getNum(),orderInfoModel.getUpdateTime(),orderInfoModel.getOrderInfoId()};
        return JDBC.executeUpdate(sql,objects);
    }

    @Override
    public int addOrderInfo(OrderInfoModel orderInfoModel) {

        String sql = "insert into order_info(order_id,good_id,price,user_id,num,colour_id," +
                "edition_id,create_time,update_time,status)values(?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{orderInfoModel.getOrderId(),orderInfoModel.getGoodId(),orderInfoModel.getPrice(),
                orderInfoModel.getUserId(),orderInfoModel.getNum(),orderInfoModel.getColourId(),orderInfoModel.getEditionId(),
                orderInfoModel.getCreateTime(),orderInfoModel.getUpdateTime(),orderInfoModel.getStatus()};
        return JDBC.executeUpdate(sql,objects);
    }
}
