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
     *
     * @Param: []
     * @Return: java.util.List<java.util.Map>
     * @Author: WuGuo
     * @Date: 2019/9/26 13:18
     */
    @Override
    public List<Map> listGoodInfoAll() {
        String sql = "\tSELECT\n" +
                "\tgi.info_id AS infoID,\n" +
                "\tgi.good_id AS goodID,\n" +
                "\tg.good_name AS goodName,\n" +
                "\tgi.brand,\n" +
                "\tgi.weight,\n" +
                "\tgi.origin,\n" +
                "\tgi.interface_phone AS interfacePhone,\n" +
                "\tgi.`status` \n" +
                "FROM\n" +
                "\tgood_info gi\n" +
                "\tLEFT JOIN good g ON gi.good_id = g.good_id \n" +
                "WHERE\n" +
                "\tgi.`status` =1";
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
        String sql = "SELECT\n" +
                "\tgi.info_id AS infoID,\n" +
                "\tgi.good_id AS goodID,\n" +
                "\tg.good_name AS goodName,\n" +
                "\tgi.brand,\n" +
                "\tgi.weight,\n" +
                "\tgi.origin,\n" +
                "\tgi.interface_phone AS interfacePhone,\n" +
                "\tgi.`status` \n" +
                "FROM\n" +
                "\tgood_info gi\n" +
                "\tLEFT JOIN good g ON gi.good_id = g.good_id \n" +
                "WHERE\n" +
                "\tgi.`status` =1 AND\n" +
                "\tgi.info_id=?";
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
        String sql = "UPDATE good_info SET `status` = 0 WHERE info_id = ?";
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
                "(good_id,brand,weight,origin,interface_phone) " +
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
