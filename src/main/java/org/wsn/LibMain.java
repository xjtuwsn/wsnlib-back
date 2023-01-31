package org.wsn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.wsn.mapper")
public class LibMain {
    public static void main(String[] args) {
        SpringApplication.run(LibMain.class, args);
    }
}