package com.sep.order.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年12月14日 22:50
 */
@Data
@ApiModel(value="订单查询", description="订单查询")
public class OrderDto {

    private Integer userId;

    private  Integer currentPage=0;

    private Integer pageSize=20;
}
