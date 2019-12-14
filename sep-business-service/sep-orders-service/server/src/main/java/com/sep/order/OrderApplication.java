package com.sep.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年12月14日 18:27
 */
@SpringCloudApplication
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.sep")
@MapperScan("com.sep.order.repository")
public class OrderApplication {

    public static void main(String [] args){
        SpringApplication.run(OrderApplication.class,args);
    }
}
