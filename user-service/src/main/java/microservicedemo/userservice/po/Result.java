package microservicedemo.userservice.po;

import lombok.Data;

@Data
public class Result {
    int msg;  //1 成功；0 失败；2 密码错误
    String token;
}
