package cn.microservicedemo.userclient.model;

import lombok.Data;

@Data
public class User {
    int id;
    String username;
    String password;
    String phone;
    String gender;
}
