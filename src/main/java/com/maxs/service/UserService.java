package com.maxs.service;

import com.maxs.dao.IUserDao;
import com.maxs.dao.impl.UserDaoImpl;
import com.maxs.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private IUserDao userDaoImpl = new UserDaoImpl();
    private HttpSession session;

    public UserService() {

    }

    public UserService(HttpServletRequest request) {
        session = request.getSession(true);
        session.setMaxInactiveInterval(600);
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
        List<Map> list = listBaseInfo(userModel);
        Map<String, Object> data = new HashMap<>();
        if (list.size() > 0) {
            data.put("status", 0);
            data.put("msg", "注册失败,用户已存在");
        } else {
            int insertResult = userDaoImpl.insertUserInfo(userModel);
            if (insertResult > 0) {
                data.put("status", 1);
                data.put("msg", "注册成功");
            } else {
                data.put("status", 0);
                data.put("msg", "注册失败,请重新尝试");
            }
        }
        return data;
    }

    public Map login(UserModel userModel) {
        List<Map> list = listBaseInfo(userModel);
        Map<String, Object> data = new HashMap<>();
        if (list.size() > 0) {
            if (!userModel.getPw().equals(list.get(0).get("pw"))) {
                data.put("status", 0);
                data.put("msg", "登录失败,账号或密码有误");
            } else {
                data.put("userId", list.get(0).get("userId"));
                data.put("status", 1);
                data.put("msg", "登录成功");
                session.setAttribute("userId", list.get(0).get("userId"));
            }
        } else {
            data.put("status", 0);
            data.put("msg", "登录失败,用户不存在");
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
        if (session.getAttribute("userId") != null) {
            session.invalidate();
        }
        Map<String, Object> data = new HashMap<>();
        data.put("status", 1);
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
            data.put("msg", "修改失败");
            ;
        }
        return data;
    }
}
