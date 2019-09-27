package com.maxs.service;

import com.maxs.dao.IOrderDao;
import com.maxs.dao.impl.OrderDaoImpl;
import com.maxs.model.OrderModel;

import java.util.List;
import java.util.Map;

public class OrderService {
    IOrderDao iOrderDao = new OrderDaoImpl();

    public List<Map> getOrder(OrderModel orderModel) {
        return  iOrderDao.getOrder(orderModel);
    }

    public int updateOrder(OrderModel orderModel) {
        return  iOrderDao.update(orderModel);
    }

    public int updateOrderstatus(OrderModel orderModel) {
        return iOrderDao.updateOrderstatus(orderModel);
    }

    public List<Map> getOrderByState(OrderModel orderModel) {
        return iOrderDao.getOrderByState(orderModel);
    }

    public int addOrder(OrderModel orderModel) {
        return iOrderDao.addOrder(orderModel);
    }
}
