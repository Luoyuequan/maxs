package com.maxs.service;

import com.maxs.dao.IOrderInfoDao;
import com.maxs.dao.impl.OrderInfoDaoImpl;
import com.maxs.model.OrderInfoModel;

import java.util.List;
import java.util.Map;

public class OrderInfoService {
    IOrderInfoDao iOrderInfoDao = new OrderInfoDaoImpl();
    public List<Map> getOrderInfo(OrderInfoModel orderInfoModel) {

        return iOrderInfoDao.getOrderInfo(orderInfoModel);
    }

    public int updateGoodsNum(OrderInfoModel orderInfoModel) {
        return iOrderInfoDao.updateGoodsNum(orderInfoModel);
    }

    public int addOrderInfo(OrderInfoModel orderInfoModel) {

        return iOrderInfoDao.addOrderInfo(orderInfoModel);
    }
}
