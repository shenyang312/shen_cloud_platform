package com.shen.cloud;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by emmet
 * create at 30/11/2017
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {

        return new Queue(QueueCode.TEST_ONE);

    }

    @Bean
    public Queue helloQueueasef() {

        return new Queue(QueueCode.TEST_TWO);

    }
}
