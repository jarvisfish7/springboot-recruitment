package com.gdpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gdpu.mapper")
public class RecuitmentWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecuitmentWebApplication.class, args);
    }

}
