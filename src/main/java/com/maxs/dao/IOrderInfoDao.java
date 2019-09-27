package com.maxs.dao;

import com.maxs.model.OrderInfoModel;

import java.util.List;
import java.util.Map;

public interface IOrderInfoDao {
    List<Map> getOrderInfo(OrderInfoModel orderInfoModel);

    int updateGoodsNum(OrderInfoModel orderInfoModel);

    int addOrderInfo(OrderInfoModel orderInfoModel);
}
