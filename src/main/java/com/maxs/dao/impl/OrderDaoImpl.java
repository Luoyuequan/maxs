package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IOrderDao;
import com.maxs.model.OrderModel;

import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements IOrderDao {
    @Override
    public List<Map> getOrder(OrderModel orderModel) {

        String sql = "select * from `order` where user_id = ? and state = ? and status = 1";
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
}
