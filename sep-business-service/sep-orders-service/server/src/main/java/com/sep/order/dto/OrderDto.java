package com.sep.order.dto;

import lombok.Data;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年12月14日 22:50
 */
@Data
public class OrderDto {

    private Integer userId;

    private  Integer currentPage=0;

    private Integer pageSize=20;
}
