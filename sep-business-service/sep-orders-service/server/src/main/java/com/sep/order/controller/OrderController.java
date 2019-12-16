package com.sep.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.sep.common.controller.BaseController;
import com.sep.common.model.response.ResponseData;
import com.sep.order.common.OrderInput;
import com.sep.order.common.OrderOutput;
import com.sep.order.dto.OrderDto;
import com.sep.order.model.Order;
import com.sep.order.service.OrderService;
import com.sep.order.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年08月10日 18:51
 */
@RequestMapping("order")
@RestController
@Api(value = "订单相关API", tags = {"订单相关API"})
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/getOrdersByUserId")
    @ApiOperation(value = "根据用户查询订单分页信息", httpMethod = "POST")
    public ResponseData<IPage<OrderVo>> getAllOrdersByUserId(@RequestBody OrderDto orderDto){
        if(orderDto.getUserId() == null){
            return ResponseData.ERROR("用户id为空");
        }
        IPage<Order> orderPage = orderService.findOrderPage(orderDto);
        IPage<OrderVo> orderVoPageInfo = new Page<>();
        orderVoPageInfo.setPages(orderPage.getPages());
        orderVoPageInfo.setCurrent(orderPage.getCurrent());
        orderVoPageInfo.setSize(orderPage.getSize());
        orderVoPageInfo.setTotal(orderPage.getTotal());
        if(!CollectionUtils.isEmpty(orderPage.getRecords())){
            List<OrderVo> orderVoList = Lists.newArrayList();
            for(Order order : orderPage.getRecords()){
                OrderVo orderVo = new OrderVo();
                orderVo.setOrderNo(order.getOrderNo());
                orderVo.setUserId(order.getUserId());
                orderVoList.add(orderVo);
            }

            orderVoPageInfo.setRecords(orderVoList);
        }
        return ResponseData.OK(orderVoPageInfo);
    }

    /**
     * 根据id获取订单信息（给用户服务调用）
     * @param orderInput
     * @return
     */
    @PostMapping(value = "/getOrderById")
    @ApiOperation(value = "根据id查询订单信息", httpMethod = "POST")
    public OrderOutput getOrderById(@RequestBody OrderInput orderInput){
        Order order = orderService.getById(orderInput.getId());
        if(order != null){
            OrderOutput orderOutput = new OrderOutput();
            BeanUtils.copyProperties(order,orderOutput);
            return orderOutput;
        }
        return null;
    }


}
