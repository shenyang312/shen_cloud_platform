package com.shen.cloud.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Service;

@Service
//@RabbitListener(queues= QueueCode.TEST_ONE)
public class Reciver {

    @RabbitHandler
    public void process(String hello){
        System.out.print("reciver:"+hello);
    }
}
