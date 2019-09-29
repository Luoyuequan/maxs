package com.maxs.dao;

import com.maxs.model.GoodTypeModel;

import java.util.List;
import java.util.Map;

public interface IGoodTypeDao {
    /**
     * 查询商品分类信息
     *
     * @return 商品分类信息列表
     */
    List<Map> listGoodTypeInfo(GoodTypeModel goodTypeModel);

    /**
     * 新增商品分类信息
     *
     * @param goodTypeModel 商品分类数据模型
     * @return 新增影响行数 0:新增失败
     */
    int insertGoodTypeInfo(GoodTypeModel goodTypeModel);

    /**
     * 修改商品分类信息
     *
     * @param goodTypeModel 商品分类数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateGoodTypeInfo(GoodTypeModel goodTypeModel);

    /**
     * 更改商品分类状态
     *
     * @param goodTypeModel 商品分类数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateGoodTypeStatus(GoodTypeModel goodTypeModel);
}
