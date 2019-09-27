package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IAdminDao;
import com.maxs.model.AdminModel;

import java.util.List;
import java.util.Map;

public class AdminDaoImpl implements IAdminDao {
    /**
     * 查询指定管理员信息
     *
     * @param adminModel 管理员数据模型
     * @return 信息list
     */
    @Override
    public List<Map> listSingleAdminInfo(AdminModel adminModel) {
        String sql = "select " +
                "admin_id as adminId,admin_name as adminName,pw,create_time as createTime,last_login_time as lastLoginTime " +
                "from admin where `status` = 1 and (admin_id = ? or admin_name = ?)";
        Object[] param = new Object[]{adminModel.getAdminId(), adminModel.getAdminName()};
        return JDBC.excuteQuery(sql, param);
    }

    /**
     * 查询所有管理员信息
     *
     * @return 所有管理员信息
     */
    @Override
    public List<Map> listAllAdminInfo() {
        String sql = "select admin_id as adminId,admin_name as adminName,pw,create_time as createTime,last_login_time as lastLoginTime from admin where `status` = 1";
        return JDBC.excuteQuery(sql);
    }

    /**
     * 新增管理员数据
     *
     * @param adminModel 管理员数据模型
     * @return 新增影响行数 0:修改失败
     */
    @Override
    public int insertAdminInfo(AdminModel adminModel) {
        String sql = "insert into admin (admin_name,pw,create_time) values(?,?,?)";
        Object[] param = new Object[]{adminModel.getAdminName(), adminModel.getPw(), adminModel.getCreateTime()};
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 获取管理员密码
     *
     * @param adminModel 管理员数据模型
     * @return 密码
     */
    @Override
    public Object getPwInfo(AdminModel adminModel) {
        String sql = "select pw from admin where admin_id = ? or admin_name = ?";
        Object[] param = new Object[]{adminModel.getAdminId(), adminModel.getAdminName()};
        return JDBC.excuteQuery(sql, param);
    }

    /**
     * 更改管理员最后登录时间
     *
     * @param adminModel 管理员数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateLastLoginTime(AdminModel adminModel) {
        String sql = "update admin set last_login_time = ? where admin_id = ? or admin_name = ?";
        Object[] param = new Object[]{adminModel.getLastLoginTime(), adminModel.getAdminId(), adminModel.getAdminName()};
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 更改管理员状态
     *
     * @param adminModel 管理员数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateAdminStatus(AdminModel adminModel) {
        String sql = "update admin set `status` = ? where admin_id = ? or admin_name = ?";
        Object[] param = new Object[]{adminModel.getStatus(), adminModel.getAdminId(), adminModel.getAdminName()};
        return JDBC.executeUpdate(sql, param);
    }
}
