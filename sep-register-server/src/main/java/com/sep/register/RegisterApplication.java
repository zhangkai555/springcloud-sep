package com.sep.register;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangkai
 * @date 2019/7/28 10:55
 */
@EnableEurekaServer
@SpringCloudApplication
public class RegisterApplication {

    public static void main(String [] args){
        SpringApplication.run(RegisterApplication.class,args);
    }
}
