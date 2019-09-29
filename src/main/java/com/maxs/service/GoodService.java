package com.maxs.service;

import com.maxs.dao.IGoodDao;
import com.maxs.dao.impl.GoodDaoImpl;
import com.maxs.model.GoodModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 11:30
 */
public class GoodService {
    private IGoodDao goodDao = new GoodDaoImpl();

    //获取所有
    public List<Map> listGoodAll() {
        return goodDao.listGoodAll();
    }

    //查
    public List<Map> getGood(GoodModel goodModel) {
        List<Map> mapList = goodDao.getGoodByID(goodModel.getGoodID());
        int i = (mapList != null) && (mapList.size() > 0) ? 1 : 0;
        mapList.add(result(i));

        return mapList;
    }

    //删
    public Map deleteC(GoodModel goodModel) {
        int i  = goodDao.removeGoodByID(goodModel.getGoodID());

        return result(i);
    }

    //增
    public Map saveC(GoodModel good) {
        int i = goodDao.saveGood(good);
        return result(i);
    }

    //改
    public Map updateC(GoodModel good) {
        int i = goodDao.updateGoodByID(good);
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
