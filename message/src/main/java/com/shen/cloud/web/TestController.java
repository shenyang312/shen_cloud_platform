package com.shen.cloud.web;

import com.shen.cloud.client.MessageClient;
import com.shen.cloud.entity.PythonEntity;
import com.shen.cloud.entity.ZmResult;
import com.shen.cloud.service.PythonEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private MessageClient messageClient;
    @Resource
    private PythonEntityService pythonEntityService;

    @RequestMapping(value = "getSystemNos")
    public ZmResult getSystemNos(){
        String msg = "hello feign:"+new Date();
        System.out.println("Sender:"+msg);
        logger.info("========<记录>++++++++");
        pythonEntityService.addPythonEntity(PythonEntity.builder().id(123123123).build());
        return new ZmResult("123","321");
    }
}
