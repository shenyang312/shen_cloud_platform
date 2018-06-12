package com.shen.exhibition.controller;

import com.shen.exhibition.utils.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestOne {
    @Autowired
    private Sender sender;

    @RequestMapping("appset")
    public String testOne(){
        sender.send();
        return null;
    }
}
