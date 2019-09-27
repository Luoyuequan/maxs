package com.maxs.service;

import com.maxs.dao.IGoodDao;
import com.maxs.dao.impl.GoodDaoImpl;
import com.maxs.model.GoodModel;

import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 11:30
 */
public class GoodService {
    private IGoodDao goodDao=new GoodDaoImpl();
    //获取所有
    public List<Map> listGoodAll(){
        return  goodDao.listGoodAll();
    }

    //查
    public List<Map> getName(){
        return  goodDao.getGoodByID(1);
    }
    //删
    public int deleteC(){
        return goodDao.removeGoodByID(1);
    }
    //增
    public int saveC(GoodModel good){
        return goodDao.saveGood(good);
    }
    //改
    public int updateC(GoodModel good){
        return goodDao.updateGoodByID(good);
    }
}
