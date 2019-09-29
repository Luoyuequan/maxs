package com.maxs.dao;

import com.maxs.model.GoodModel;

import java.util.List;
import java.util.Map;

public interface IGoodDao {
    //查询所有信息
    List<Map> listGoodAll();

    //根据ID查询
    List<Map> getGoodByID(int channelID);

    //根据ID删除
    int removeGoodByID(int channelID);

    //添加
    int saveGood(GoodModel channel);

    //修改
    int updateGoodByID(GoodModel channel);
}

