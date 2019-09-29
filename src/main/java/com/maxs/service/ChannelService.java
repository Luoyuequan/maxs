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
    public List<Map> getChannel(ChannelModel channel) {
        List<Map> mapList = channelDao.getChannelByID(channel.getChannelID());
        int i = (mapList != null) && (mapList.size() > 0) ? 1 : 0;
        mapList.add(result(i));
        return mapList;
    }

    //删
    public Map deleteC(ChannelModel channel) {
        int i = channelDao.removeChannelByID(channel.getChannelID());
        return result(i);
    }

    //增
    public Map saveC(ChannelModel channel) {
        int i = channelDao.saveChannel(channel);
        return result(i);
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
            map.put("mag", "失败！");
        }
        return map;
    }
}
