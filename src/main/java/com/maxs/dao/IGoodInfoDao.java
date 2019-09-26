package com.maxs.dao;

import com.maxs.model.GoodInfoModel;

import java.util.List;
import java.util.Map;

public interface IGoodInfoDao {
    //查询所有信息
    List<Map> listGoodInfoAll();

    //根据ID查询
    List<Map> getGoodInfoByID(int goodInfoID);

    //根据ID删除
    int removeGoodInfoByID(int goodInfoID);

    //添加
    int saveGoodInfo(GoodInfoModel goodInfo);

    //修改
    int updateGoodInfoByID(GoodInfoModel goodInfo);
}
