package com.maxs.service;

import com.maxs.dao.IGoodInfoDao;
import com.maxs.dao.impl.GoodInfoDaoImpl;
import com.maxs.model.GoodInfoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 13:04
 */
public class GoodInfoService {
    private IGoodInfoDao goodInfoDao = new GoodInfoDaoImpl();

    //获取所有
    public List<Map> listGoodInfo() {
        return goodInfoDao.listGoodInfoAll();
    }

    //查
    public List<Map> getGoodInfo(String str) {
        List<Map> mapList = new ArrayList<>();
        if (str != null && str != "") {
            mapList = goodInfoDao.getGoodInfoByID(Integer.parseInt(str));
            int i = (mapList != null) && (mapList.size() > 0) ? 1 : 0;
            mapList.add(result(i));
        } else {
            Map map=new HashMap();
            map.put("status", 0);
            map.put("mag", "输入为空！");
            mapList.add(map);
        }
        return mapList;
    }

    //删
    public Map deleteC(String str) {
//        = (goodInfoID!=0)?1:0;
        int i = 0;
        if (str != null && str != "") {
            i = goodInfoDao.removeGoodInfoByID(Integer.parseInt(str));
        }
        return result(i);
    }

    //增
    public Map saveC(GoodInfoModel goodInfo) {
        int i = goodInfoDao.saveGoodInfo(goodInfo);
        return result(i);
    }

    //改
    public Map updateC(GoodInfoModel goodInfo) {
        int i = goodInfoDao.updateGoodInfoByID(goodInfo);
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
