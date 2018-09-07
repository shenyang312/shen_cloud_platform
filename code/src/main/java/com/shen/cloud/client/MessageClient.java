package com.shen.cloud.client;

import com.shen.cloud.entity.ZmResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "message")
public interface MessageClient {

    @RequestMapping(value = "addStatisticalBussiness")
    ZmResult addStatisticalBussiness(@RequestBody ZmResult statisticalBusiness);


    @Component
    class MessageClientHystric implements MessageClient{
        @Override
        public ZmResult addStatisticalBussiness(ZmResult statisticalBusiness) {
            return new ZmResult("123","123");
        }

    }
}
