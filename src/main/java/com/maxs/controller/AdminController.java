package com.maxs.controller;

import com.maxs.common.RequestIsJson;
import com.maxs.model.AdminModel;
import com.maxs.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService = new AdminService();
    private AdminModel adminModel;
    private Class claszz = AdminModel.class;
    private RequestIsJson<AdminModel> requestIsJson = new RequestIsJson<>();

    /**
     * 登录
     *
     * @param request 请求
     * @return 登录信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(HttpServletRequest request, HttpServletResponse response) {
        //*表示允许所有域名跨域
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        String lastLoginTime = String.valueOf(System.currentTimeMillis());
        adminModel = requestIsJson.getJsonToModel(request, claszz);
        adminModel.setLastLoginTime(lastLoginTime);
        return adminService.login(adminModel);
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
        return adminService.logout();
    }

    /**
     * 指定管理员信息
     *
     * @param request 请求
     * @return 信息集
     */
    @RequestMapping(value = "/listSingleInfo", method = RequestMethod.POST)
    public List<Map> listSingleInfo(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        adminModel = requestIsJson.getJsonToModel(request, claszz);
        return adminService.listSingleInfo(adminModel);
    }

    /**
     * 所有管理员信息
     *
     * @param request 请求
     * @return 所有管理员信息集
     */
    @RequestMapping(value = "/listAllInfo", method = RequestMethod.POST)
    public List<Map> listAllInfo(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        adminModel = requestIsJson.getJsonToModel(request, claszz);
        return adminService.listAllInfo(adminModel);
    }

    /**
     * 添加管理员
     *
     * @param request 请求
     * @return 添加结果信息
     */
    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public List<Map> addAdmin(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        String createTime = String.valueOf(System.currentTimeMillis());
        adminModel = requestIsJson.getJsonToModel(request, claszz);
        adminModel.setCreateTime(createTime);
        return adminService.addAdmin(adminModel);
    }

    /**
     * 删除指定管理员
     * 更改状态码
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
    public Map deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int adminStatus = 2;
        adminModel = requestIsJson.getJsonToModel(request, claszz);
        adminModel.setStatus(adminStatus);
        return adminService.deleteAdmin(adminModel);
    }
}
