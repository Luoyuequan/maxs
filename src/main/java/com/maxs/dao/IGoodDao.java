package com.maxs.dao;

import com.maxs.model.GoodModel;

import java.util.List;
import java.util.Map;

public interface IGoodDao {
    //查询所有信息
    List<Map> listGoodAll();

    //根据ID查询
    List<Map> getGoodByID(int goodID);

    //根据ID删除
    int removeGoodByID(GoodModel goodModel);

    //添加
    int saveGood(GoodModel goodModel);

    //修改
    int updateGoodByID(GoodModel goodModel);
}

