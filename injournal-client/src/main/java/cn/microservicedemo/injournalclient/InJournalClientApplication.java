package cn.microservicedemo.injournalclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages =
        {"cn.microservicedemo.injournalclient.controller","cn.microservicedemo.injournalclient.Client"})
@EnableEurekaClient
@EnableFeignClients("cn.microservicedemo.injournalclient.Client")
public class InJournalClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(InJournalClientApplication.class, args);
    }
}

