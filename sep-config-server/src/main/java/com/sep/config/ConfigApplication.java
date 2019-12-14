package com.sep.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhangkai
 * @date 2019/7/28 11:04
 */
@SpringCloudApplication
@EnableConfigServer
public class ConfigApplication {

    public static void main(String [] args){
        SpringApplication.run(ConfigApplication.class,args);
    }
}
