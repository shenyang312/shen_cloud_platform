package com.shen.cloud.controller;

import com.shen.cloud.QueueCode;
import com.shen.cloud.client.MessageClient;
import com.shen.cloud.entity.Deploy;
import com.shen.cloud.service.DeployService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;


@RestController
public class TestOne {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AmqpTemplate rabbitTemplate;

    @Resource
    private MessageClient messageClient;

    @Resource
    private DeployService deployService;

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
        deployService.addDeploy(Deploy.builder().uuid(UUID.randomUUID().toString()).build());
        messageClient.getSystemNos();
        return null;
    }
}
