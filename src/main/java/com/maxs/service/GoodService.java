package com.maxs.service;

import com.maxs.dao.IColourDao;
import com.maxs.dao.IEditionDao;
import com.maxs.dao.IGoodDao;
import com.maxs.dao.impl.ColorDaoImpl;
import com.maxs.dao.impl.EditionDaoImpl;
import com.maxs.dao.impl.GoodDaoImpl;
import com.maxs.model.GoodModel;

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
    private IColourDao colourDao = new ColorDaoImpl();
    private IEditionDao editionDao = new EditionDaoImpl();

    //获取所有
    public List<Map> listGoodAll() {
        return goodDao.listGoodAll();
    }

    //查
    public List<Map> getGood(GoodModel goodModel) {
        List<Map> mapList = goodDao.getGoodByID(goodModel.getGoodID());
        String str = Integer.toString(goodModel.getGoodID());
        if (mapList.get(0) != null) {
            mapList.get(0).put("colour", getColourByGoodID(str));
            mapList.get(0).put("edition", getEditionByGoodID(str));
        }
        int i = (mapList != null) && (mapList.size() > 0) ? 1 : 0;
        mapList.add(result(i));

        return mapList;
    }

    //获取商品对应颜色
    private List<Map> getColourByGoodID(String goodID) {
        return colourDao.getColour(goodID);
    }

    private List<Map> getEditionByGoodID(String goodID) {
        return editionDao.getEditon(goodID);
    }


    //删
    public Map deleteC(GoodModel goodModel) {
        int i = goodDao.removeGoodByID(goodModel);

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
