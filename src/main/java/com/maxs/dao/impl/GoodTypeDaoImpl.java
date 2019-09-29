package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IGoodTypeDao;
import com.maxs.model.GoodTypeModel;

import java.util.List;
import java.util.Map;

public class GoodTypeDaoImpl implements IGoodTypeDao {
    /**
     * 查询商品分类信息
     *
     * @return 商品分类信息列表
     */
    @Override
    public List<Map> listGoodTypeInfo(GoodTypeModel goodTypeModel) {
        String sql = "select good_type_id as goodTypeId,type_name as typeName," +
                "parent_id as parentId,create_time as createTime,update_time as updateTime," +
                "admin_id as adminId from good_type where `status` = ?";
        Object[] param = new Object[]{
                goodTypeModel.getStatus() == 0 ? 1 : goodTypeModel.getStatus()
        };
        return JDBC.excuteQuery(sql,param);
    }

    /**
     * 新增商品分类信息
     *
     * @param goodTypeModel 商品分类数据模型
     * @return 新增影响行数 0:新增失败
     */
    @Override
    public int insertGoodTypeInfo(GoodTypeModel goodTypeModel) {
        String sql = "insert into good_type (type_name,parent_id,create_time,admin_id) values(?,?,?,?)";
        Object[] param = new Object[]{
                goodTypeModel.getTypeName(),
                goodTypeModel.getParentId(),
                goodTypeModel.getCreateTime(),
                goodTypeModel.getAdminId()
        };
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 修改商品分类信息
     *
     * @param goodTypeModel 商品分类数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateGoodTypeInfo(GoodTypeModel goodTypeModel) {
        String sql = "update " +
                "good_type set type_name = ?,parent_id = ?,update_time = ?,admin_id = ? " +
                "where good_type_id = ? and `status` = ?";
        Object[] param = new Object[]{
                goodTypeModel.getTypeName(),
                goodTypeModel.getParentId(),
                goodTypeModel.getUpdateTime(),
                goodTypeModel.getAdminId(),
                goodTypeModel.getGoodTypeId(),
                goodTypeModel.getStatus() == 0 ? 1 : goodTypeModel.getStatus()
        };
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 更改商品分类状态
     *
     * @param goodTypeModel 商品分类数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateGoodTypeStatus(GoodTypeModel goodTypeModel) {
        String sql = "update good_type set `status` = ?,update_time = ?,admin_id = ? where good_type_id = ?";
        Object[] param = new Object[]{
                goodTypeModel.getStatus() == 0 ? 1 : goodTypeModel.getStatus(),
                goodTypeModel.getUpdateTime(),
                goodTypeModel.getAdminId(),
                goodTypeModel.getGoodTypeId()
        };
        return JDBC.executeUpdate(sql, param);
    }
}
