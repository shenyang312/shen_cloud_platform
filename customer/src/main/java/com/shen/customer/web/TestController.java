package com.shen.customer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class TestController {
    @Value("${zidingyi}")
    private String from = "1111";

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }
}
