package com.sep.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sep.order.dto.OrderDto;
import com.sep.order.model.Order;
import com.sep.order.repository.OrderMapper;
import com.sep.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年12月14日 15:52
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService{

    @Override
    public IPage<Order> findOrderPage(OrderDto orderDto) {
        IPage<Order> result = new Page<>();
        QueryWrapper<Order> wrapper = new QueryWrapper<Order>();

        if(orderDto.getUserId() != null){
            wrapper.ge("user_id", orderDto.getUserId());
        }
        IPage<Order> page = baseMapper.selectPage(new Page<>(orderDto.getCurrentPage(), orderDto.getPageSize()), wrapper);
        result.setPages(page.getPages());
        result.setCurrent(page.getCurrent());
        result.setSize(page.getSize());
        result.setTotal(page.getTotal());
        result.setRecords(page.getRecords());
        return result;
    }
}
