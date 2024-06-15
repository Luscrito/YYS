package cn.microservicedemo.userclient.controller;

import cn.microservicedemo.userclient.Client.UserServiceClient;
import cn.microservicedemo.userclient.Utils.JwtUtil;
import cn.microservicedemo.userclient.model.Result;
import cn.microservicedemo.userclient.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@RestController
@Slf4j
public class UserServiceClientController {
    @Autowired
    private UserServiceClient userServiceClient;
    @PostMapping("/search")
    public Result Login(@RequestBody User user){
        User user1 = userServiceClient.getByName(user);
        Result result = new Result();
        if(user1==null){
            result.setMsg(0);
            return result;
        }
        else if(!Objects.equals(user1.getPassword(), user.getPassword())){
            result.setMsg(2);
            return result;
        }
        result.setMsg(1);
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", user1.getId());
        claim.put("username", user1.getUsername());
        result.setToken(JwtUtil.createJWT("zhouchongrui",5*1000*60*60,claim));
        return result;
    }

    @PostMapping("/register")
    public Result add(@RequestBody User user){
        return userServiceClient.add(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userServiceClient.update(user);
        Result result = new Result();
        result.setMsg(1);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        userServiceClient.delete(id);
        Result result = new Result();
        result.setMsg(1);
        return result;
    }

    @GetMapping("/getall")
    public List<User> getAllUser(){
        return userServiceClient.getAllUser();
    }
}
