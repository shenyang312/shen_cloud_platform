package com.shen.cloud.autoConfig;

import com.shen.cloud.interceptes.MybatisIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPluginsConfig {

    @Bean
    public MybatisIntercept TableSplitByModuloInterceptor() {
        return new MybatisIntercept();
    }
}
