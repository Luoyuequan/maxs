package com.maxs.service;

import com.maxs.dao.IGoodInfoDao;
import com.maxs.dao.impl.GoodInfoDaoImpl;
import com.maxs.model.GoodInfoModel;

import java.util.List;
import java.util.Map;

/**
 * @program: maxs
 * @author: Wu Guo
 * @create: 2019-09-26 13:04
 */
public class GoodInfoService {
    private IGoodInfoDao goodInfoDao= new GoodInfoDaoImpl();
    //获取所有
    public List<Map> listGoodInfo(){
        return goodInfoDao.listGoodInfoAll();
    }

    //查
    public List<Map> getGoodInfo(){
        return  goodInfoDao.getGoodInfoByID(1);
    }
    //删
    public int deleteC(){
        return goodInfoDao.removeGoodInfoByID(1);
    }
    //增
    public int saveC(GoodInfoModel goodInfo){
        return goodInfoDao.saveGoodInfo(goodInfo);
    }
    //改
    public int updateC(GoodInfoModel goodInfo){
        return goodInfoDao.updateGoodInfoByID(goodInfo);
    }

}
