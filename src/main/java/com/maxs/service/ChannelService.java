package com.maxs.service;

import com.maxs.dao.IChannelDao;
import com.maxs.dao.impl.ChannelDaoImpl;
import com.maxs.model.ChannelModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-25 16:53
 */
public class ChannelService {
    private IChannelDao channelDao = new ChannelDaoImpl();

    //获取所有
    public List<Map> listChannel() {
        return channelDao.listChannelAll();
    }

    //查
    public List<Map> getChannel(int id) {
        List<Map> channelByID = channelDao.getChannelByID(id);
        Map result = null;
        if (channelByID != null) {
            result = result(1);
        } else {
            result = result(0);

        }
        channelByID.add(result);
        return channelByID;
    }

    //删
    public Map deleteC(int id) {
        int i = channelDao.removeChannelByID(id);
        Map result = result(i);
        return result;
    }

    //增
    public Map saveC(ChannelModel channel) {
        int i = channelDao.saveChannel(channel);
        Map result = result(i);
        return result;
    }

    //改
    public Map updateC(ChannelModel channel) {
        int i = channelDao.updateChannelByID(channel);
        return result(i);
    }

    /**
     * 〈判断操作结果，生成状态〉
     *
     * @Param: [i]
     * @Return: java.util.Map
     * @Author: WuGuo
     * @Date: 2019/9/26 16:22
     */
    private Map result(int i) {
        Map map = new HashMap();
        if (i > 0) {
            map.put("status", 1);
            map.put("mag", "成功！");
        } else {
            map.put("status", 0);
            map.put("mag", "删除失败！");
        }
        return map;
    }
}
