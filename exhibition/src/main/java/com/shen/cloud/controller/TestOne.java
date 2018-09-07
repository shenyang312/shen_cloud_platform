package com.shen.cloud.controller;

import com.shen.cloud.QueueCode;
import com.shen.cloud.client.MessageClient;
import com.sun.istack.internal.logging.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


@RestController
public class TestOne {

    private final Logger logger = Logger.getLogger(getClass());

    @Resource
    private AmqpTemplate rabbitTemplate;

    @Resource
    private MessageClient messageClient;

    @RequestMapping("appset")
    public String testOne(){
//        sender.send();
        String msg = "hello rabbitmq:"+new Date();
        System.out.println("Sender:"+msg);
        rabbitTemplate.convertAndSend(QueueCode.TEST_ONE, msg);
        return null;
    }

    @RequestMapping("feignTest")
    public String feignTest(){
//        sender.send();
        String msg = "hello feign:"+new Date();
        System.out.println("Sender:"+msg);
        logger.info("========<记录>++++++++=========");
        messageClient.getSystemNos();
        return null;
    }
}
