package com.sep.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zhangkai
 * @date 2019/7/28 10:55
 */
@SpringCloudApplication
public class GateWayApplication {

    public static void main(String [] args){
        SpringApplication.run(GateWayApplication.class,args);
    }
}
