package com.springcloud.fast.fastspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignMain8084 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8084.class, args);
    }

}
