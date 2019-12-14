package com.sep.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sep.order.dto.OrderDto;
import com.sep.order.model.Order;
import com.sep.order.vo.OrderVo;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年12月14日 15:50
 */
public interface OrderService extends IService<Order>{

    IPage<Order> findOrderPage(OrderDto orderDto);

}
