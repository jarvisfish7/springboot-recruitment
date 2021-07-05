package com.gdpu.config;

import com.gdpu.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    FileUtil fileUtil;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(fileUtil.getImg());
        registry.addResourceHandler("/pic/**").addResourceLocations(fileUtil.getImg());
    }
}
