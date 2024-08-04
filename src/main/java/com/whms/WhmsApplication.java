package com.whms;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMPP
public class WhmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WhmsApplication.class, args);
    }

}
