package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IChannelDao;
import com.maxs.model.ChannelModel;

import java.util.List;
import java.util.Map;

/**
 * Channel表的增删改查
 *
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-25 16:16
 */
public class ChannelDaoImpl implements IChannelDao {
    @Override
    public List<Map> listChannelAll() {
        String sql = "SELECT channel_id as channelID,channel_name as channelName," +
                "create_time as createTime,update_time as updateTime," +
                "admin_id as adminID,status" +
                " FROM channel";
        return JDBC.excuteQuery(sql);
    }

    /**
     * 〈根据ID获取对应信息〉
     *
     * @Param: [channelID]
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 10:51
     */
    @Override
    public List<Map> getChannelByID(int channelID) {
        String sql = "SELECT channel_id as channelID,channel_name as channelName," +
                "create_time as createTime,update_time as updateTime," +
                "admin_id as adminID,status" +
                " FROM channel WHERE channel_id=?";
        return JDBC.excuteQuery(sql, new Object[]{channelID});
    }

    /**
     * 〈根据ID删除，即修改状态码〉
     *
     * @Param: [channelID]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 10:51
     */
    @Override
    public int removeChannelByID(int channelID) {
        String sql = "UPDATE channel SET status = 0 WHERE channel_id = ?";
        return JDBC.executeUpdate(sql, new Object[]{channelID});
    }

    /**
     * 〈添加数据〉
     *
     * @Param: [channel]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 10:52
     */
    @Override
    public int saveChannel(ChannelModel channel) {
        String sql = "INSERT INTO channel (channel_name,create_time,update_time,admin_id) VALUES (?,?,?,?);";
        Object[] object = new Object[]{channel.getChannelName(),
                channel.getCreateTime(), channel.getUpdateTime(), channel.getAdminID()};
        return JDBC.executeUpdate(sql, object);
    }

    @Override
    public int updateChannelByID(ChannelModel channel) {
        String sql = "UPDATE channel SET channel_name=?," +
                "update_time=?,admin_id=? " +
                "WHERE channel_id = ?";
        Object[] object = new Object[]{channel.getChannelName(),channel.getUpdateTime(),
                channel.getAdminID(), channel.getChannelID()};
        return JDBC.executeUpdate(sql, object);
    }
}
