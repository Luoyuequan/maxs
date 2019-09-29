package com.maxs.dao;

import com.maxs.model.OrderModel;

import java.util.List;
import java.util.Map;

public interface IOrderDao {
    List<Map> getOrder(OrderModel orderModel);

    int update(OrderModel orderModel);

    int updateOrderstatus(OrderModel orderModel);

    List<Map> getOrderByState(OrderModel orderModel);

    int addOrder(OrderModel orderModel);

    List<Map> getOrderInfo(OrderModel orderModel);
}
