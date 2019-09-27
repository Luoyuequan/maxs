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

    public Map registerUser(UserModel userModel) {
        int insertResult = userDaoImpl.insertUserInfo(userModel);
        Map<String, Object> data = new HashMap<>();
        if (insertResult > 0) {
            data.put("status", 1);
            data.put("msg", "新增成功");
        } else {
            data.put("status", 0);
            data.put("msg", "新增失败");
        }
        return data;
    }

    public Map login(UserModel userModel) {
        List<Map> list = userDaoImpl.listBaseInfo(userModel);
        Map<String, Object> data = new HashMap<>();
        if (list.size()>0) {
            if (!list.get(0).get("pw").equals(userModel.getPw())){
                data.put("userId",list.get(0).get("userId"));
                data.put("status", 0);
                data.put("msg", "登录失败");
            }
            else {
                data.put("status", 1);
                data.put("msg", "登录成功");
            }
        } else {
            data.put("status", 0);
            data.put("msg", "登录失败");
        }
        return data;
    }

    public Map deleteUser(UserModel userModel) {
        int updateResult = userDaoImpl.updateUserStatus(userModel);
        Map<String, Object> data = new HashMap<>();
        if (updateResult > 0) {
            data.put("status", updateResult);
            data.put("msg", "删除成功");
        } else {
            data.put("status", updateResult);
            data.put("msg", "删除失败");
        }
        return data;
    }

    public Map logout() {
        Map<String, Object> data = new HashMap<>();
        data.put("status",1);
        data.put("msg", "注销成功");
        return data;
    }

    public Map updateUserInfo(UserModel userModel) {
        int updateResult = userDaoImpl.updateUserInfo(userModel);
        Map<String, Object> data = new HashMap<>();
        if (updateResult > 0) {
            data.put("status", 1);
            data.put("msg", "修改成功");
        } else {
            data.put("status", 0);
            data.put("msg", "修改失败");
        }
        return data;
    }

    public Map changePw(UserModel userModel) {
        int updateResult = userDaoImpl.updatePasswd(userModel);
        Map<String, Object> data = new HashMap<>();
        if (updateResult > 0) {
            data.put("status", 1);
            data.put("msg", "修改成功");
        } else {
            data.put("status", 0);
            data.put("msg", "修改失败");;
        }
        return data;
    }
}
