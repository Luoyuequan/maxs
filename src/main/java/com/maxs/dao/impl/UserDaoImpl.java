package com.maxs.dao.impl;

import com.maxs.common.JDBC;
import com.maxs.dao.IUserDao;
import com.maxs.model.UserModel;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements IUserDao {

    /**
     * 查询指定用户基本信息
     *
     * @param userModel 用户数据模型
     * @return 基本信息list
     */
    @Override
    public List<Map> listBaseInfo(UserModel userModel) {
        String sql = "select * from user where user_id = ? or user_account = ?";
        Object[] param = new Object[]{userModel.getUserId(), userModel.getUserAccount()};
        return JDBC.excuteQuery(sql, param);
    }

    /**
     * 查询指定用户更多信息
     *
     * @param userModel 用户数据模型
     * @return 更多信息list
     */
    @Override
    public List<Map> listMoreInfo(UserModel userModel) {
        String sql = "select * from user where user_id = ? or user_account = ?";
        Object[] param = new Object[]{userModel.getUserId(), userModel.getUserAccount()};
        return JDBC.excuteQuery(sql, param);
    }

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    @Override
    public List<Map> listAllUserInfo() {
        String sql = "select * from user";
        return JDBC.excuteQuery(sql);
    }

    /**
     * 新增用户数据
     *
     * @param userModel 用户数据模型
     * @return 新增影响行数 0:修改失败
     */
    @Override
    public int insertUserInfo(UserModel userModel) {
        String sql = "insert into user (user_account,pw,create_time) values(?,?,?)";
        Object[] param = new Object[]{userModel.getUserAccount(), userModel.getPw(), userModel.getCreateTime()};
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 获取用户密码
     *
     * @param userModel 用户数据模型
     * @return 密码
     */
    @Override
    public Object getPwInfo(UserModel userModel) {
        String sql = "select pw from user where user_account = ? or user_id = ?";
        Object[] param = new Object[]{userModel.getUserAccount(), userModel.getUserId()};
        return JDBC.excuteQuery(sql, param);
    }

    /**
     * 更改用户最后登录时间
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateLastLoginTime(UserModel userModel) {
        String sql = "update user set last_login_time = ? where user_id = ? or user_account = ?";
        Object[] param = new Object[]{userModel.getLastLoginTime(), userModel.getUserId(), userModel.getUserAccount()};
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 更改绑定QQ
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateBindQq(UserModel userModel) {
        String sql = "update user set qq = ? where user_id = ? or user_account = ?";
        Object[] param = new Object[]{userModel.getQq(), userModel.getUserId(), userModel.getUserAccount()};
        return JDBC.executeUpdate(sql, param);
    }

    /**
     * 更改用户状态
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateUserStatus(UserModel userModel) {
        String sql = "update user set status = ? where user_id = ? or user_account = ?";
        Object[] param = new Object[]{userModel.getStatus(), userModel.getUserId(), userModel.getUserAccount()};
        return JDBC.executeUpdate(sql, param);
    }
}
