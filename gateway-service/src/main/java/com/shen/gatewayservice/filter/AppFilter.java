package com.shen.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;

@Component//需要被Spring管理
public class AppFilter extends ZuulFilter {

    /**
     * 路由生命周期：
     * pre->routing->post->error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";//请求路由之前被拦截
    }

    @Override
    public int filterOrder() {
        return 1;//过滤器：等级
    }

    /**
     * 判断路由器是否执行方法，返回true执行，fasle不执行
     * 白名单此处加入
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑：return结束
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        return null;
    }
}
