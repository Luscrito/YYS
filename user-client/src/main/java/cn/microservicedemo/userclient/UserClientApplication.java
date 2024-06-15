package cn.microservicedemo.userclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages =
        {"cn.microservicedemo.userclient.controller", "cn.microservicedemo.userclient.Client"})
@EnableEurekaClient
@EnableFeignClients("cn.microservicedemo.userclient.Client")
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }
}

