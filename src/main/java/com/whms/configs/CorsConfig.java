package com.whms.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  // 允许访问了路径
                .allowCredentials(true) // 是否允许证书
                    .allowedOriginPatterns("*")    // 设置允许跨域请求的域名
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许 GET, POST, PUT, DELETE 方法
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
