package cn.microservicedemo.userclient.model;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
public class Result {
    int msg;  //1 成功；0 失败；2 密码错误
    String token;
}
