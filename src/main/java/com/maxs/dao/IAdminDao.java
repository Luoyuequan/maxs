package com.maxs.dao;

import com.maxs.model.AdminModel;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
    /**
     * 查询指定管理员信息
     *
     * @param adminModel 管理员数据模型
     * @return 信息list
     */
    List<Map> listSingleAdminInfo(AdminModel adminModel);

    /**
     * 查询所有管理员信息
     *
     * @return 所有管理员信息
     */
    List<Map> listAllAdminInfo(AdminModel adminModel);

    /**
     * 新增管理员数据
     *
     * @param adminModel 管理员数据模型
     * @return 新增影响行数 0:修改失败
     */
    int insertAdminInfo(AdminModel adminModel);

    /**
     * 获取管理员密码
     *
     * @param adminModel 管理员数据模型
     * @return 密码
     */
    Object getPwInfo(AdminModel adminModel);

    /**
     * 更改管理员最后登录时间
     *
     * @param adminModel 管理员数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateLastLoginTime(AdminModel adminModel);

    /**
     * 更改管理员状态
     *
     * @param adminModel 管理员数据模型
     * @return 修改影响行数 0:修改失败
     */
    int updateAdminStatus(AdminModel adminModel);
}
