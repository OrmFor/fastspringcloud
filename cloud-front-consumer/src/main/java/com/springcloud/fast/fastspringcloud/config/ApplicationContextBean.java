package com.springcloud.fast.fastspringcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ApplicationContextBean {
    @Bean
    @LoadBalanced//轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
