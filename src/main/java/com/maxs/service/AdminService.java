package com.maxs.service;

import com.maxs.dao.IAdminDao;
import com.maxs.dao.impl.AdminDaoImpl;
import com.maxs.model.AdminModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private IAdminDao adminDaoImpl;

    public AdminService() {
        this.adminDaoImpl = new AdminDaoImpl();
    }

    public Map login(AdminModel adminModel) {
        List<Map> list = adminDaoImpl.listSingleAdminInfo(adminModel);
        Map<String, Object> data = new HashMap<>();
        if (list != null) {
            data.put("status", 1);
            data.put("msg", "登录成功");
        } else {
            data.put("status", 0);
            data.put("msg", "登录失败");
        }
        return data;
    }

    public Map logout() {
        Map<String, Object> data = new HashMap<>();
        data.put("status",1);
        data.put("msg", "注销成功");
        return data;
    }

    public List<Map> listSingleInfo(AdminModel adminModel) {
        return adminDaoImpl.listSingleAdminInfo(adminModel);
    }

    public List<Map> listAllInfo() {
        return adminDaoImpl.listAllAdminInfo();
    }

    public List<Map> addAdmin(AdminModel adminModel) {
        int insertResult = adminDaoImpl.insertAdminInfo(adminModel);
        List<Map> msg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (insertResult > 0) {
            map.put("status", insertResult);
            map.put("msg", "新增成功");
            msg.add(map);
        } else {
            map.put("status", insertResult);
            map.put("msg", "新增失败");
            msg.add(map);
        }
        return msg;
    }

    public Map deleteAdmin(AdminModel adminModel) {
        int updateResult = adminDaoImpl.updateAdminStatus(adminModel);
        Map<String, Object> map = new HashMap<>();
        if (updateResult > 0) {
            map.put("status", updateResult);
            map.put("msg", "删除成功");
        } else {
            map.put("status", updateResult);
            map.put("msg", "删除失败");
        }
        return map;
    }
}
