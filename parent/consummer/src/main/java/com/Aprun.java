package com;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan(basePackages = {"cn.bdqn","com.bdqn"})
public class Aprun {
    public static void main(String[] args) {
        SpringApplication.run(Aprun.class);
    }
}
