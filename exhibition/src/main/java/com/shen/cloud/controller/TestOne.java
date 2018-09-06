package com.shen.cloud.controller;

import com.shen.cloud.QueueCode;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


@RestController
public class TestOne {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("appset")
    public String testOne(){
//        sender.send();
        String msg = "hello rabbitmq:"+new Date();
        System.out.println("Sender:"+msg);
        rabbitTemplate.convertAndSend(QueueCode.TEST_ONE, msg);
        return null;
    }
}
