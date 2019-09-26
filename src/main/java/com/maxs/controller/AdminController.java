package com.maxs.controller;

import com.maxs.model.AdminModel;
import com.maxs.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
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
        response.setHeader("Access-Control-Allow-Methods", "POST");
        String adminName = request.getParameter("adminName") == null ? "" : request.getParameter("adminName");
        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        String lastLoginTime = String.valueOf(System.currentTimeMillis());
        AdminModel adminModel = new AdminModel();
        adminModel.setAdminName(adminName);
        adminModel.setPw(pw);
        adminModel.setLastLoginTime(lastLoginTime);
        AdminService adminService = new AdminService();
        return adminService.login(adminModel);
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
        AdminService adminService = new AdminService();
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
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int adminId = request.getParameter("adminId") == null ? 0 : Integer.parseInt(request.getParameter("adminId"));
        AdminModel adminModel = new AdminModel();
        adminModel.setAdminId(adminId);
        AdminService adminService = new AdminService();
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
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        AdminService adminService = new AdminService();
        return adminService.listAllInfo();
    }

    /**
     * 添加管理员
     *
     * @param request 请求
     * @return 添加结果信息
     */
    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public List<Map> addAdmin(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        String adminName = request.getParameter("adminName") == null ? "" : request.getParameter("adminName");
        String pw = request.getParameter("pw") == null ? "" : request.getParameter("pw");
        String createTime = String.valueOf(System.currentTimeMillis());
        AdminModel adminModel = new AdminModel();
        adminModel.setAdminName(adminName);
        adminModel.setPw(pw);
        adminModel.setCreateTime(createTime);
        AdminService adminService = new AdminService();
        return adminService.addAdmin(adminModel);
    }

    /**
     * 删除指定管理员
     * 更改状态码
     *
     * @param request 请求
     * @return 更改结果信息
     */
    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.POST)
    public List<Map> deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        int adminId = request.getParameter("adminId") == null ? 0 : Integer.parseInt(request.getParameter("adminId"));
        int userStatus = 2;
        AdminModel adminModel = new AdminModel();
        adminModel.setAdminId(adminId);
        adminModel.setStatus(userStatus);
        AdminService adminService = new AdminService();
        return adminService.deleteAdmin(adminModel);
    }
}
