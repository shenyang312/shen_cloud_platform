package com.shen.message.mqListen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="emailQueue")
public class Reciver {

    @RabbitHandler
    public void process(String hello){
        System.out.print("reciver:"+hello);
    }
}
