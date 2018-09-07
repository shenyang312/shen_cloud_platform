package com.shen.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ExhibitionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ExhibitionApplication.class, args);
        String[] beanNames =  ctx.getBeanDefinitionNames();

        System.out.println("所以beanNames个数："+beanNames.length);

        for(String bn:beanNames){

            System.out.println(bn);

        }
    }
}
