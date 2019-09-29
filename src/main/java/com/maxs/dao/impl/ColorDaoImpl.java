package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IColourDao;
import com.maxs.model.ColourModel;

import java.util.List;
import java.util.Map;

public class ColorDaoImpl implements IColourDao {

    @Override
    public List<Map> getColour(String goodsId) {
        String sql = "select colour_id colourId,good_id goodId,colour_name colourName,colour_url colourUrl from colour where good_id = ?";

        Object[] objects = new Object[]{goodsId};
        return JDBC.excuteQuery(sql,objects);
    }

    @Override
    public int delColour(String colourId) {
        String sql = "delete from colour where colour_id = ?";
        Object[] objects = new Object[]{colourId};
        return JDBC.executeUpdate(sql,objects);
    }

    @Override
    public int addColour(ColourModel colourModel) {
        String sql = "insert into colour (good_id,colour_name,colour_url) values (?,?,?)";
        Object[] objects = new Object[]{colourModel.getGoodsId(),colourModel.getColourName(),colourModel.getColourUrl()};
        return JDBC.executeUpdate(sql,objects);
    }
}
