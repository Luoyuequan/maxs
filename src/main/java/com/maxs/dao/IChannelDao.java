package com.maxs.dao;

import com.maxs.model.ChannelModel;

import java.util.List;
import java.util.Map;

public interface IChannelDao {

    //获取所有值
    List<Map> listChannelAll();

    //根据ID查询
    List<Map> getChannelByID(int channelID);

    //根据ID删除
    int removeChannelByID(ChannelModel channel);

    //添加
    int saveChannel(ChannelModel channel);

    //修改
    int updateChannelByID(ChannelModel channel);
}
