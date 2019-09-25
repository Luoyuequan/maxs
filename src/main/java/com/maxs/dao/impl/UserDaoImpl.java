package com.maxs.dao.impl;

import com.maxs.dao.IUserDao;
import com.maxs.model.UserModel;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements IUserDao {
    /**
     * 用户基本信息
     *
     * @param userModel 用户数据模型
     * @return 基本信息list
     */
    @Override
    public List<Map> listBaseInfo(UserModel userModel) {
        return null;
    }

    /**
     * 用户更多信息
     *
     * @param userModel 用户数据模型
     * @return 更多信息list
     */
    @Override
    public List<Map> listMoreInfo(UserModel userModel) {
        return null;
    }

    /**
     * 获取用户密码
     *
     * @param userModel 用户数据模型
     * @return 密码
     */
    @Override
    public Object getPwInfo(UserModel userModel) {
        return null;
    }

    /**
     * 更改用户最后登录时间
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateLastLoginTime(UserModel userModel) {
        return 0;
    }

    /**
     * 更改绑定QQ
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    @Override
    public int updateBindQq(UserModel userModel) {
        return 0;
    }
}
