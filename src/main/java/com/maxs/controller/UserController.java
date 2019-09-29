package com.maxs.controller;

import com.alibaba.fastjson.JSONObject;
import com.maxs.common.RequestIsJson;
import com.maxs.model.UserModel;
import com.maxs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService = new UserService();
    private UserModel userModel;
    private Class claszz = UserModel.class;
    private RequestIsJson<UserModel> requestIsJson = new RequestIsJson<>();

    /**
     * 登录
     *
     * @param request 请求
     * @return 登录信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @PostMapping("/login")
    public Map login(HttpServletRequest request, HttpServletResponse response) {
        //*表示允许所有域名跨域
//        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        System.out.println(request.getContentType());
        System.out.println(request.getHeader("Origin"));
        System.out.println(request.getHeader("Accept"));
        String lastLoginTime = String.valueOf(System.currentTimeMillis());
        userModel = requestIsJson.getJsonToModel(request, claszz);
        userModel.setLastLoginTime(lastLoginTime);
        System.out.println(userModel.getUserAccount());
        System.out.println(userModel.getPw());
        this.userService = new UserService(request);
        return userService.login(userModel);
    }

    /**
     * 注销
     *
     * @param request 请求
     * @return 注销信息
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Map logout(HttpServletRequest request, HttpServletResponse response) {
        //*表示允许所有域名跨域
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        this.userService = new UserService(request);
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
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        userModel = requestIsJson.getJsonToModel(request, claszz);
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
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        userModel = requestIsJson.getJsonToModel(request, claszz);
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
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        return userService.listAllUserInfo();
    }

    /**
     * 添加用户
     *
     * @param request 请求
     * @return 添加结果信息
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public Map registerUser(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        String userAccount = request.getParameter("userAccount") == null ? "" : request.getParameter("userAccount");
//        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        String createTime = String.valueOf(System.currentTimeMillis());
        userModel = requestIsJson.getJsonToModel(request, claszz);
        userModel.setCreateTime(createTime);
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
    public Map deleteUser(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userStatus = 2;
        userModel = requestIsJson.getJsonToModel(request, claszz);
        userModel.setStatus(userStatus);
        return userService.deleteUser(userModel);
    }

    /**
     * 更改用户信息
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public Map updateUserInfo(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        int sex = request.getParameter("sex") == null ? 0 : Integer.parseInt(request.getParameter("sex"));
        int userType = request.getParameter("userType") == null ? 1 : Integer.parseInt(request.getParameter("userType"));
        int qq = request.getParameter("qq") == null ? 0 : Integer.parseInt(request.getParameter("qq"));
        userModel = requestIsJson.getJsonToModel(request, claszz);
        return userService.updateUserInfo(userModel);
    }

    /**
     * 更改密码
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/changePw", method = RequestMethod.POST)
    public Map changePw(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int userId = request.getParameter("userId") == null ? 0 : Integer.parseInt(request.getParameter("userId"));
        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        userModel = requestIsJson.getJsonToModel(request, claszz);
        return userService.changePw(userModel);
    }
}
