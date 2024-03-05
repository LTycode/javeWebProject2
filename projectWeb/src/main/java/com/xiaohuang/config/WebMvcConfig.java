package com.xiaohuang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    //对文件的路径进行配置,创建一个虚拟路径/DataShow_IMAGE/** ，即只要在<img src="/DataShow_IMAGE/picName.jpg" />便可以直接引用图片
       //这是图片的物理路径  "file:/+本地图片的地址
		 registry.addResourceHandler("/DataShow_IMAGE/**").addResourceLocations("file:D:/DataShow_IMAGE");
	    }
}
