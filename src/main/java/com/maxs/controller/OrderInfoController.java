package com.maxs.controller;

import com.maxs.common.RequestIsJson;
import com.maxs.common.ReturnMap;
import com.maxs.model.OrderInfoModel;
import com.maxs.model.OrderModel;
import com.maxs.service.OrderInfoService;
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
public class OrderInfoController {

    ReturnMap returnMap = new ReturnMap();
    OrderInfoModel orderInfoModel = new OrderInfoModel();
    OrderInfoService orderInfoService = new OrderInfoService();
    private Class claszz = OrderInfoModel.class;
    private RequestIsJson<OrderInfoModel> requestIsJson = new RequestIsJson<>();

    /**
     * 根据order_id获取该订单存在的所有商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/getOrderInfo", method = RequestMethod.POST)
    public String getOrderInfo(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域

        orderInfoModel = requestIsJson.getJsonToModel(request, claszz);
        List<Map> list = orderInfoService.getOrderInfo(orderInfoModel);
        return returnMap.getGetReMap(list);
    }

    @RequestMapping("/addOrderInfo")
    public String addOrderInfo(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        String createTime = String.valueOf(System.currentTimeMillis());
        orderInfoModel = requestIsJson.getJsonToModel(request, claszz);
        orderInfoModel.setCreateTime(createTime);
        orderInfoModel.setStatus("1");
        int i = orderInfoService.addOrderInfo(orderInfoModel);
        return returnMap.getaddReMap(i);
    }

//    /**
//     * 修改订单中的商品数量
//     * @param request num，order_info_id
//     * @param response
//     * @return
//     */
//    @RequestMapping("/updateGoodsNum")
//    public String updateGoodsNum(HttpServletRequest request,HttpServletResponse response){
//        String num = request.getParameter("num");
//        String orderInfoId = request.getParameter("order_info_id");
//        String updateTime= String.valueOf(System.currentTimeMillis());
//        orderInfoModel.setOrderInfoId(orderInfoId);
//        orderInfoModel.setNum(num);
//        orderInfoModel.setUpdateTime(updateTime);
//        int i = orderInfoService.updateGoodsNum(orderInfoModel);
//        return returnMap.getUpdateReMap(i);
//    }
//
//
//    /**
//     * 修改订单中状态
//     * @param request
//     * @param response
//     * @return
//     */
//    public String updateOrderInfoStatus(HttpServletRequest request,HttpServletResponse response){
//        String orderInfoId = request.getParameter("order_info_id");
//        String status = request.getParameter("status");
//        String updateTime= String.valueOf(System.currentTimeMillis());
//    }
}
