package com.maxs.service;

import com.maxs.dao.IUserDao;
import com.maxs.dao.impl.UserDaoImpl;
import com.maxs.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private IUserDao userDaoImpl;

    public UserService() {
        this.userDaoImpl = new UserDaoImpl();
    }

    public List<Map> listBaseInfo(UserModel userModel) {
        return userDaoImpl.listBaseInfo(userModel);
    }

    public List<Map> listMoreInfo(UserModel userModel) {
        return userDaoImpl.listMoreInfo(userModel);
    }

    public List<Map> listAllUserInfo() {
        return userDaoImpl.listAllUserInfo();
    }

    public List<Map> registerUser(UserModel userModel) {
        int insertResult = userDaoImpl.insertUserInfo(userModel);
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

    public List<Map> login(UserModel userModel) {
        return userDaoImpl.listBaseInfo(userModel);
    }

    public List<Map> deleteUser(UserModel userModel) {
        int insertResult = userDaoImpl.updateUserStatus(userModel);
        List<Map> msg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if (insertResult > 0) {
            map.put("status", insertResult);
            map.put("msg", "删除成功");
            msg.add(map);
        } else {
            map.put("status", insertResult);
            map.put("msg", "删除失败");
            msg.add(map);
        }
        return msg;
    }

    public List<Map> logout() {
        List<Map> msg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
//        if (insertResult > 0) {
//            map.put("status", insertResult);
            map.put("msg", "注销成功");
            msg.add(map);
//        } else {
//            map.put("status", insertResult);
//            map.put("msg", "删除失败");
//            msg.add(map);
//        }
        return msg;
    }
}
