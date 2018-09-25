package com.shen.cloud.utils;

import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TxManagerHttpRequestServicelmpl implements TxManagerHttpRequestService {
    @Override
    public String httpGet(String url) {
        System.out.println("==========="+url);
        //GET请求前
        String res = HttpUtils.get(url);
        //GET请求后
        return res;

    }

    @Override
    public String httpPost(String url, String params) {
        System.out.println("+++++++++++++++"+url);
        //POST请求前
        String res = HttpUtils.post(url, params);
        //POST请求后
        return res;

    }
}
