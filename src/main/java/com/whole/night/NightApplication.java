package com.whole.night;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whole.night.mapper")  //mapper接口需要被扫描
public class NightApplication {

    public static void main(String[] args) {
        SpringApplication.run(NightApplication.class, args);
    }

}
