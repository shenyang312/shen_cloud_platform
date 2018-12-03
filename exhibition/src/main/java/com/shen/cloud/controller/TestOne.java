package com.shen.cloud.controller;

import com.shen.cloud.QueueCode;
import com.shen.cloud.entity.Deploy;
import com.shen.cloud.service.DeployService;
import com.shen.cloud.util.RedissLockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RestController
public class TestOne {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AmqpTemplate rabbitTemplate;

    @Resource
    private DeployService deployService;

    private final String _lock  = "_lock";

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getCurrentDate(){
        return sdf.format(new Date());
    }

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
        deployService.addDeploy(Deploy.builder().uuid(UUID.randomUUID().toString()).name("feignTest").build());
        return null;
    }

    @RequestMapping(value = "/testlock",method= RequestMethod.GET)
    public String testlock(String name) {

        new Thread(() -> {

            RedissLockUtil.lock(_lock, TimeUnit.MINUTES, 10);

            System.out.println(getCurrentDate()+" "+name+" begin...");
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(getCurrentDate()+" "+name+" "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getCurrentDate()+" "+name+" end...");

            RedissLockUtil.unlock(_lock);
        }).start();

        return "testlock";
    }
}
