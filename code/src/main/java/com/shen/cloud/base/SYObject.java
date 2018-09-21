package com.shen.cloud.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class SYObject implements Serializable {
    /**
     * 通过JSON重写对象的toString方法
     * @return
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
