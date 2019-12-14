package com.sep.user.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * RequestMapping必须跟cloud服务的Controller对应
 * 不支持GET方法传递POJO,可以拆成一个个单独的属性放在参数里
 *
 * @author zhangkai
 * @date 2019年07月20日 22:22
 */
@FeignClient(name = "sep-user-service")
public interface UserClient {
}
