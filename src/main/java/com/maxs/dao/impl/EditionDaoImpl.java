package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IEditionDao;
import com.maxs.model.EditionModel;

import java.util.List;
import java.util.Map;

public class EditionDaoImpl implements IEditionDao {
    @Override
    public List<Map> getEditon(String goodsId) {

        String sql = "select * from edition where good_id = ? and state = 1";
        Object[] objects = new Object[1];
        objects[0] = goodsId;
        return JDBC.excuteQuery(sql,objects);
    }

    @Override
    public int updateEdition(EditionModel editionModel) {

        String sql = "update edition set edition_name = ? where edition_id = ?";

        Object[] objects = new Object[]{editionModel.getEditionName(),editionModel.getEditionId()};
        return JDBC.executeUpdate(sql,objects);
    }

    @Override
    public int delEdition(EditionModel editionModel) {
        String sql = "update edition set state = 2 where edition_id = ?";
        Object[] objects = new Object[]{editionModel.getEditionId()};
        return  JDBC.executeUpdate(sql,objects);
    }

    @Override
    public int addEdition(EditionModel editionModel) {

        String sql = "insert into edition(good_id,edition_name) values(?,?)";
        Object[] objects = new Object[]{editionModel.getGoodId(),editionModel.getEditionName()};
        return JDBC.executeUpdate(sql,objects);
    }
}
