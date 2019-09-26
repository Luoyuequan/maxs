package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IGoodInfoDao;
import com.maxs.model.GoodInfoModel;

import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 11:10
 */
public class GoodInfoDaoImpl implements IGoodInfoDao {
    /**
     * 〈获取good_info表中所有的值〉
     * @Param: []
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 13:18
     */
    @Override
    public List<Map> listGoodInfoAll() {
        String sql = "SELECT info_id as infoID,good_id as goodID,brand,weight," +
                "origin,interface_phone as interfacePhone,status FROM good_info";
        return JDBC.excuteQuery(sql);
    }

    /**
     * 〈根据ID获取信息〉
     *
     * @Param: [goodID]
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 12:48
     */
    @Override
    public List<Map> getGoodInfoByID(int goodInfoID) {
        String sql = "SELECT info_id as infoID, good_id as goodID,brand,weight,origin," +
                "interface_phone as interfacePhone,status FROM good_info WHERE info_id=?";
        return JDBC.excuteQuery(sql, new Object[]{goodInfoID});
    }

    /**
     * 〈根据ID进行删除，即修改状态值〉
     *
     * @Param: [goodID]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:49
     */
    @Override
    public int removeGoodInfoByID(int goodInfoID) {
        String sql = "UPDATE good_info SET status = 0 WHERE info_id = ?";
        return JDBC.executeUpdate(sql, new Object[]{goodInfoID});
    }

    /**
     * 〈添加信息〉
     *
     * @Param: [good]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:49
     */
    @Override
    public int saveGoodInfo(GoodInfoModel goodInfo) {
        String sql = "INSERT INTO good_info " +
                "(good_id,brand,weight,origin,interface_phone" +
                "VALUES (?,?,?,?,?);";
        Object[] object = new Object[]{goodInfo.getGoodID(), goodInfo.getBrand(),
                goodInfo.getWeight(), goodInfo.getOrigin(), goodInfo.getInterfacePhone()};
        return JDBC.executeUpdate(sql, object);
    }

    /**
     * 〈根据ID进行信息修改〉
     *
     * @Param: [good]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/26 12:50
     */
    @Override
    public int updateGoodInfoByID(GoodInfoModel goodInfo) {
        String sql = "UPDATE good_info SET good_id=?,brand=?,weight=?," +
                "origin=?,interface_phone=? WHERE info_id = ?";
        Object[] object = new Object[]{goodInfo.getGoodID(), goodInfo.getBrand(),
                goodInfo.getWeight(), goodInfo.getOrigin(),
                goodInfo.getInterfacePhone(), goodInfo.getInfoID()};
        return JDBC.executeUpdate(sql, object);
    }
}
