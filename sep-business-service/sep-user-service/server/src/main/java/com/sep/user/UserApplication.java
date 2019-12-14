package com.sep.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年12月14日 18:27
 */
@SpringCloudApplication
@EnableHystrixDashboard
@EnableFeignClients(basePackages = "com.sep.order.client")
@ComponentScan(basePackages = "com.sep")
@MapperScan("com.sep.user.repository")
public class UserApplication {

    public static void main(String [] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
