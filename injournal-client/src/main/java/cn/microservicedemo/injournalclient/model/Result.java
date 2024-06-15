package cn.microservicedemo.injournalclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    int msg;  //1 成功；0 失败；2 密码错误
}
