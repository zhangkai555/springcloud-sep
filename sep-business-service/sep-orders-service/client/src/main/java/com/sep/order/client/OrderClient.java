package com.sep.order.client;

import com.sep.order.common.OrderInput;
import com.sep.order.common.OrderOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RequestMapping必须跟cloud服务的Controller对应
 * 不支持GET方法传递POJO,可以拆成一个个单独的属性放在参数里
 *
 * @author zhangkai
 * @date 2019年07月20日 22:22
 */
@FeignClient(name = "sep-order-service")
public interface OrderClient {

    @PostMapping("/order/getOrderById")
    OrderOutput getOrderById(@RequestBody OrderInput orderInput);
}
