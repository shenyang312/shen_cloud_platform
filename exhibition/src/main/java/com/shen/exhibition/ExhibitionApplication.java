package com.shen.exhibition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ExhibitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExhibitionApplication.class, args);
    }
}
