package com.maxs.dao;

import com.maxs.model.UserModel;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    /**
     * 用户基本信息
     *
     * @param userModel 用户数据模型
     * @return 基本信息list
     */
    List<Map> listBaseInfo(UserModel userModel);

    /**
     * 用户更多信息
     *
     * @param userModel 用户数据模型
     * @return 更多信息list
     */
    List<Map> listMoreInfo(UserModel userModel);

    /**
     * 获取用户密码
     *
     * @param userModel 用户数据模型
     * @return 密码
     */
    Object getPwInfo(UserModel userModel);

    /**
     * 更改用户最后登录时间
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateLastLoginTime(UserModel userModel);

    /**
     * 更改绑定QQ
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateBindQq(UserModel userModel);
}
