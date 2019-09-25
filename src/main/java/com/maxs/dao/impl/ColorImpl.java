package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IColourDao;

import java.util.List;
import java.util.Map;

public class ColorImpl implements IColourDao {

    @Override
    public List<Map> getColour() {
        String sql = "select * from color";
        return JDBC.excuteQuery(sql);
    }
}
