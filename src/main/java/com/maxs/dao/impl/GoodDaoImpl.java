package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IGoodDao;
import com.maxs.model.GoodModel;

import java.util.List;
import java.util.Map;

/**
 * Good表的增删改查
 *
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 11:10
 */
public class GoodDaoImpl implements IGoodDao {
    @Override
    public List<Map> listGoodAll() {
        String sql = "SELECT good_id as goodID,good_name as goodName," +
                "type_id as typeID,channel_id as channelID," +
                "price,admin_id as adminID,create_time as createTime," +
                "update_time as updateTime,hot,banner,`status`" +
                " FROM good";
        return JDBC.excuteQuery(sql);
    }

    /**
     * 〈根据ID获取信息〉
     * @Param: [goodID]
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 12:48
     */
    @Override
    public List<Map> getGoodByID(int goodID) {
        String sql = "SELECT good_id as goodID,good_name as goodName," +
                "type_id as typeID,channel_id as channelID," +
                "price,admin_id as adminID,create_time as createTime," +
                "update_time as updateTime,hot,banner,`status`" +
                " FROM good WHERE good_id=?";
        return JDBC.excuteQuery(sql, new Object[]{goodID});
    }

    /**
     * 〈根据ID进行删除，即修改状态值〉
     * @Param: [goodID]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:49
     */
    @Override
    public int removeGoodByID(int goodID) {
        String sql = "UPDATE good SET `status` = 0 WHERE good_id = ?";
        return JDBC.executeUpdate(sql, new Object[]{goodID});
    }

    /**
     * 〈添加信息〉
     * @Param: [good]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:49
     */
    @Override
    public int saveGood(GoodModel good) {
        String sql = "INSERT INTO good " +
                "(good_name,type_id,channel_id,price,admin_id," +
                "create_time,update_time,hot,banner) " +
                "VALUES (?,?,?,?,?,?,?,?,?);";
        Object[] object = new Object[]{good.getGoodName(), good.getTypeID(),
                good.getChannelID(), good.getPrice(), good.getAdminID(),
                good.getCreateTime(), good.getUpdateTime(), good.getHot(), good.getBanner()};
        return JDBC.executeUpdate(sql, object);
    }

    /**
     * 〈根据ID进行信息修改〉
     * @Param: [good]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:50
     */
    @Override
    public int updateGoodByID(GoodModel good) {
        String sql = "UPDATE good SET good_name=?,type_id=?,channel_id=?," +
                "price=?,admin_id=?,create_time=?,update_time=?," +
                "hot=?,banner=? WHERE good_id = ?";
        Object[] object = new Object[]{good.getGoodName(), good.getTypeID(),
                good.getChannelID(), good.getPrice(), good.getAdminID(),
                good.getCreateTime(), good.getUpdateTime(),
                good.getHot(), good.getBanner(),good.getGoodID()};
        return JDBC.executeUpdate(sql, object);
    }
}

