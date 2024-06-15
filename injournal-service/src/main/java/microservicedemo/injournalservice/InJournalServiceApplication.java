package microservicedemo.injournalservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
        {"microservicedemo.injournalservice.controller"})
@MapperScan(basePackages="microservicedemo.injournalservice.mapper")

public class InJournalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InJournalServiceApplication.class, args);
    }

}
