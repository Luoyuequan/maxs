package com.maxs.controller;

import com.maxs.common.JDBC;
import com.maxs.model.UserModel;
import com.maxs.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 登录
     *
     * @param request 请求
     * @return 登录信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public List<Map> login(HttpServletRequest request, HttpServletResponse response) {
        //*表示允许所有域名跨域
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        String userAccount = request.getParameter("userAccount") == null ? "" : request.getParameter("userAccount");
        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        String lastLoginTime = String.valueOf(System.currentTimeMillis());
        UserModel userModel = new UserModel();
        userModel.setUserAccount(userAccount);
        userModel.setPw(pw);
        userModel.setLastLoginTime(lastLoginTime);
        UserService userService = new UserService();
        return userService.login(userModel);
    }

    /**
     * 注销
     *
     * @param request 请求
     * @return 注销信息
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public List<Map> logout(HttpServletRequest request, HttpServletResponse response) {
        //*表示允许所有域名跨域
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Methods", "GET");
        UserService userService = new UserService();
        return userService.logout();
    }

    /**
     * 指定用户基本信息
     *
     * @param request 请求
     * @return 基本信息集
     */
    @RequestMapping(value = "/baseInfo", method = RequestMethod.POST)
    public List<Map> baseInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        UserService userService = new UserService();
        return userService.listBaseInfo(userModel);
    }

    /**
     * 指定用户更多信息
     *
     * @param request 请求
     * @return 更多信息集
     */
    @RequestMapping(value = "/moreInfo", method = RequestMethod.POST)
    public List<Map> moreInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        UserService userService = new UserService();
        return userService.listMoreInfo(userModel);
    }

    /**
     * 所有用户信息
     *
     * @param request 请求
     * @return 所有用户信息集
     */
    @RequestMapping(value = "/allUserInfo", method = RequestMethod.POST)
    public List<Map> allUserInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        UserService userService = new UserService();
        return userService.listAllUserInfo();
    }

    /**
     * 添加用户
     *
     * @param request 请求
     * @return 添加结果信息
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public List<Map> registerUser(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        String userAccount = request.getParameter("userAccount") == null ? "" : request.getParameter("userAccount");
        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        String createTime = String.valueOf(System.currentTimeMillis());
        UserModel userModel = new UserModel();
        userModel.setUserAccount(userAccount);
        userModel.setPw(pw);
        userModel.setCreateTime(createTime);
        UserService userService = new UserService();
        return userService.registerUser(userModel);
    }

    /**
     * 删除指定用户
     * 更改状态码
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public List<Map> deleteUser(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        int userStatus = 2;
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setStatus(userStatus);
        UserService userService = new UserService();
        return userService.deleteUser(userModel);
    }

    /**
     * 更改用户信息
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public List<Map> updateUserInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        int sex = request.getParameter("sex") == null ? 0 : Integer.parseInt(request.getParameter("sex"));
        int userType = request.getParameter("userType") == null ? 1 : Integer.parseInt(request.getParameter("userType"));
        int qq = request.getParameter("qq") == null ? 0 : Integer.parseInt(request.getParameter("qq"));
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setNickName(request.getParameter("nickName"));
        userModel.setRealName(request.getParameter("realName"));
        userModel.setSex(sex);
        userModel.setEmail(request.getParameter("email"));
        userModel.setInsert(request.getParameter("insert"));
        userModel.setUserType(userType);
        userModel.setCredit(request.getParameter("credit"));
        userModel.setQq(qq);
        UserService userService = new UserService();
        return userService.updateUserInfo(userModel);
    }

    /**
     * 更改密码
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/changePw", method = RequestMethod.POST)
    public List<Map> changePw(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setPw(pw);
        UserService userService = new UserService();
        return userService.changePw(userModel);
    }
}
