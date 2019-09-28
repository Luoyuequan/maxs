package com.maxs.controller;



import com.maxs.common.RequestIsJson;
import com.maxs.common.ReturnMap;
import com.maxs.model.ColourModel;
import com.maxs.model.OrderModel;
import com.maxs.service.OrderService;
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
public class OrderController {

    OrderModel orderModel;
    OrderService orderService = new OrderService();
    ReturnMap returnMap = new ReturnMap();
    private Class claszz = OrderModel.class;
    private RequestIsJson<OrderModel> requestIsJson = new RequestIsJson<>();
    /**
     * 根据用户id与state来查询订单
     * @param request user_id
     * @param response
     * @return
     */
    @RequestMapping(value = "/getOrder",method = RequestMethod.POST)
    public String getOrder(HttpServletRequest request, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域

        orderModel = requestIsJson.getJsonToModel(request, claszz);
        List<Map> list = orderService.getOrder(orderModel);
        return returnMap.getGetReMap(list);
    }


    /**
     * 根据用户id查询用户存在的所有有效订单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getOrderByState",method = RequestMethod.POST)
    public String getOrderByState(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        orderModel = requestIsJson.getJsonToModel(request, claszz);
        List<Map> list = orderService.getOrderByState(orderModel);

        return returnMap.getGetReMap(list);
    }

    /**
     *修改订单状态
     * @param request order_id,state
     * @param response json
     * @return
     */
    @RequestMapping(value = "/updateOrderState",method = RequestMethod.POST)
    public String updateOrderState(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        orderModel = requestIsJson.getJsonToModel(request, claszz);
        String updateTime= String.valueOf(System.currentTimeMillis());
        orderModel.setUpdateTime(updateTime);
        int i = orderService.updateOrder(orderModel);
        return returnMap.getUpdateReMap(i);
    }


    /**
     * 更改订单存在状态 status
     * @param request order_id status
     * @param response json
     * @return
     */
    @RequestMapping(value = "/updateOrderStatus",method = RequestMethod.POST)
    public String updateOrderStatus(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        orderModel = requestIsJson.getJsonToModel(request, claszz);
        int i = orderService.updateOrderstatus(orderModel);
        return returnMap.getUpdateReMap(i);
    }

    /**
     * 新增订单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)

    public String addOrder(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域

        String createTime= String.valueOf(System.currentTimeMillis());
        orderModel = requestIsJson.getJsonToModel(request, claszz);
        orderModel.setCreateTime(createTime);
        orderModel.setUpdateTime(createTime);
        orderModel.setState("1");
        orderModel.setStatus("1");
        int i = orderService.addOrder(orderModel);
        return returnMap.getaddReMap(i);
    }


}
