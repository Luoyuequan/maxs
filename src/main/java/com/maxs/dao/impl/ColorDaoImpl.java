package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IColourDao;

import java.util.List;
import java.util.Map;

public class ColorDaoImpl implements IColourDao {

    @Override
    public List<Map> getColour(String goodsId) {
        String sql = "select * from colour where good_id ="+goodsId;

        return JDBC.excuteQuery(sql);
    }
}
