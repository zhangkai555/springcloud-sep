package com.sep.user.controller;

import com.sep.common.controller.BaseController;
import com.sep.common.model.response.ResponseData;
import com.sep.order.client.OrderClient;
import com.sep.order.common.OrderInput;
import com.sep.order.common.OrderOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年08月10日 18:51
 */
@RequestMapping("user")
@RestController
public class UserController extends BaseController{

    @Autowired
    private OrderClient orderClient;

    @PostMapping(value = "/getOrderById")
    public ResponseData<OrderOutput> getOrderById(@RequestBody OrderInput orderInput){

        // 调用order提供的feign服务
        OrderOutput orderOutput = orderClient.getOrderById(orderInput);
        return ResponseData.OK(orderOutput);
    }



}
