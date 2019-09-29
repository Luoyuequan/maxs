package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IOrderDao;
import com.maxs.model.OrderModel;

import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements IOrderDao {
    @Override
    public List<Map> getOrder(OrderModel orderModel) {

        String sql = "select order_id orderId,money,user_id userId,create_time createTime,update_time ,state , status updateTime from `order` where user_id = ? and state = ? and status = 1";
        Object[] objects = new Object[]{orderModel.getUserId(),orderModel.getState()};
        return JDBC.excuteQuery(sql, objects);
    }

    @Override
    public int update(OrderModel orderModel) {
        String sql = "update `order` set state = ?  where order_id = ?";
        Object[] objects = new Object[]{orderModel.getState(),orderModel.getOrderId()};
        return JDBC.executeUpdate(sql,objects);
    }

    @Override
    public int updateOrderstatus(OrderModel orderModel) {
        String sql = "update `order` set status = ?  where order_id = ?";
        Object[] objects = new Object[]{orderModel.getStatus(),orderModel.getOrderId()};
        return JDBC.executeUpdate(sql,objects);
    }

    @Override
    public List<Map> getOrderByState(OrderModel orderModel) {
        String sql = "select * from `order` where user_id = ? and  status = 1";
        Object[] objects = new Object[]{orderModel.getUserId()};
        return JDBC.excuteQuery(sql,objects);
    }

    @Override
    public int addOrder(OrderModel orderModel) {
        String sql = "insert into `order` (user_id,money,create_time,update_time,state,`status`) values (?,?,?,?,?,?)";
        Object[] objects = new Object[]{orderModel.getUserId(),orderModel.getMoney(), orderModel.getCreateTime(),
                orderModel.getUpdateTime(),orderModel.getState(),orderModel.getStatus()};
        return JDBC.executeUpdate(sql,objects);
    }

    @Override
    public List<Map> getOrderInfo(OrderModel orderModel) {
        String sql ="SELECT\n" +
                "\to.user_id userId,\n" +
                "\to.money,\n" +
                "\to.create_time createTime,\n" +
                "\to.update_time updateTime,\n" +
                "\to.state,\n" +
                "\toi.order_info_id orderInfoId,\n" +
                "\toi.good_id goodId,\n" +
                "\toi.price,\n" +
                "\toi.num,\n" +
                "\toi.colour_id colourId,\n" +
                "\toi.edition_id editionId,\n" +
                "\toi.STATUS `status`,\n" +
                "\tco.colour_name colourName,\n" +
                "\tco.colour_url colourUrl ,\n" +
                "\ted.edition_name editionName,\n" +
                "\tgo.good_name goodName\n" +
                "FROM\n" +
                "\t`order` o\n" +
                "\tLEFT JOIN order_info oi ON o.order_id = oi.order_id\n" +
                "\tLEFT JOIN colour co ON oi.colour_id = co.colour_id \n" +
                "\tLEFT JOIN edition ed on oi.edition_id = ed.edition_id\n" +
                "\tLEFT JOIN good go on oi.good_id = go.good_id\n" +
                "WHERE\n" +
                "\to.order_id = ?";
        Object[] objects = new Object[]{orderModel.getOrderId()};
        return JDBC.excuteQuery(sql,objects);
    }
}
