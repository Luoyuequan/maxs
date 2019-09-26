package com.maxs.service;

import com.maxs.dao.IAdminDao;
import com.maxs.dao.IGoodTypeDao;
import com.maxs.dao.impl.AdminDaoImpl;
import com.maxs.dao.impl.GoodTypeDaoImpl;
import com.maxs.model.GoodTypeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodTypeService {
    private IGoodTypeDao goodTypeDaoImpl;

    public GoodTypeService() {
        this.goodTypeDaoImpl = new GoodTypeDaoImpl();
    }

    public List<Map> listAllInfo() {
        return goodTypeDaoImpl.listGoodTypeInfo();
    }

    public List<Map> addGoodType(GoodTypeModel goodTypeModel) {
        int insertResult = goodTypeDaoImpl.insertGoodTypeInfo(goodTypeModel);
        List<Map> msg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (insertResult > 0) {
            map.put("status", insertResult);
            map.put("msg", "新增成功");
            msg.add(map);
        } else {
            map.put("status", insertResult);
            map.put("msg", "新增失败");
            msg.add(map);
        }
        return msg;
    }

    public List<Map> deleteGoodType(GoodTypeModel goodTypeModel) {
        int updateResult = goodTypeDaoImpl.updateGoodTypeStatus(goodTypeModel);
        List<Map> msg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (updateResult > 0) {
            map.put("status", updateResult);
            map.put("msg", "删除成功");
            msg.add(map);
        } else {
            map.put("status", updateResult);
            map.put("msg", "删除失败");
            msg.add(map);
        }
        return msg;
    }

    public List<Map> updateGoodTypeInfo(GoodTypeModel goodTypeModel) {
        int updateResult = goodTypeDaoImpl.updateGoodTypeInfo(goodTypeModel);
        List<Map> msg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (updateResult > 0) {
            map.put("status", updateResult);
            map.put("msg", "修改成功");
            msg.add(map);
        } else {
            map.put("status", updateResult);
            map.put("msg", "修改失败");
            msg.add(map);
        }
        return msg;
    }
}
