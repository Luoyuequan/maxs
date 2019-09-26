package com.maxs.dao;

import com.maxs.model.UserModel;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    /**
     * 查询指定用户基本信息
     *
     * @param userModel 用户数据模型
     * @return 基本信息list
     */
    List<Map> listBaseInfo(UserModel userModel);

    /**
     * 查询指定用户更多信息
     *
     * @param userModel 用户数据模型
     * @return 更多信息list
     */
    List<Map> listMoreInfo(UserModel userModel);

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    List<Map> listAllUserInfo();

    /**
     * 新增用户数据
     *
     * @param userModel 用户数据模型
     * @return 新增影响行数 0:修改失败
     */
    int insertUserInfo(UserModel userModel);

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

    /**
     * 更改用户状态
     *
     * @param userModel 用户数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateUserStatus(UserModel userModel);
}
