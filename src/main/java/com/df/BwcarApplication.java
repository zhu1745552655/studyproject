package com.df;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.df.dao")
public class BwcarApplication {

    public static void main(String[] args) {
        SpringApplication.run(BwcarApplication.class, args);
    }

}
