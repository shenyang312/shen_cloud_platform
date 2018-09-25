package com.shen.cloud.client;

import com.shen.cloud.entity.ZmResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "message" , fallback = MessageClient.MessageClientHystric.class)
public interface MessageClient {

    @RequestMapping(value = "getSystemNos")
    ZmResult getSystemNos();


    @Component
    class MessageClientHystric implements MessageClient{
        @Override
        public ZmResult getSystemNos() {
            System.out.println("进入断路器-list。。。");
            throw new RuntimeException("list 保存失败.");
        }

    }
}
