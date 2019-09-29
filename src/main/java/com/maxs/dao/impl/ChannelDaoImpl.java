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
        String sql = "SELECT\n" +
                "\tc.channel_id AS channelID,\n" +
                "\tc.channel_name AS channelName,\n" +
                "\tc.create_time AS createTime,\n" +
                "\tc.update_time AS updateTime,\n" +
                "\ta.admin_name AS adminName,\n" +
                "\tc.admin_id AS adminID,\n" +
                "\tc.`status` \n" +
                "FROM\n" +
                "\tchannel c\n" +
                "\tLEFT JOIN admin a ON c.admin_id = a.admin_id \n" +
                "WHERE\n" +
                "\tc.`status` =1";
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
        String sql = "SELECT\n" +
                "\tc.channel_id AS channelID,\n" +
                "\tc.channel_name AS channelName,\n" +
                "\tc.create_time AS createTime,\n" +
                "\tc.update_time AS updateTime,\n" +
                "\ta.admin_name AS adminName,\n" +
                "\tc.admin_id AS adminID,\n" +
                "\tc.`status` \n" +
                "FROM\n" +
                "\tchannel c\n" +
                "\tLEFT JOIN admin a ON c.admin_id = a.admin_id \n" +
                "WHERE\n" +
                "\tc.channel_id = 1 AND c.`status` =1";
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
        String sql = "UPDATE channel SET `status` = 0 WHERE channel_id = ?";
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
        Object[] object = new Object[]{channel.getChannelName(), channel.getUpdateTime(),
                channel.getAdminID(), channel.getChannelID()};
        return JDBC.executeUpdate(sql, object);
    }
}
