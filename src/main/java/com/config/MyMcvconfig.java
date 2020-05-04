package com.config;

import com.Interceptor.tokenInterceptor;
import lombok.Synchronized;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2020/1/29 - 22:07
 */
@Configuration
public class MyMcvconfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }
    @Bean
    public tokenInterceptor authenticationInterceptor() {
        return new tokenInterceptor();
    }

    /*上传图片*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "d:/workspace/img/");
    }




}
