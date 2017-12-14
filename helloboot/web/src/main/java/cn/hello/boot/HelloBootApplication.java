package cn.hello.boot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.hello.boot.dao")
public class HelloBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }}
