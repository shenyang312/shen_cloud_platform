package com.shen.exhibition.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//创建配置类，进行队列、交换器、路由的配置
@Configuration
public class RabbitQueue {
    @Bean
    public Queue helloQueue() {

        return new Queue("emailQueue");

    }
}
