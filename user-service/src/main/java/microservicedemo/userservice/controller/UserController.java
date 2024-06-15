package microservicedemo.userservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservicedemo.userservice.mapper.UserMapper;
import microservicedemo.userservice.po.Result;
import microservicedemo.userservice.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user/search")
    public User getByName(@RequestBody User user) {
        log.info("-------------OK search User!-------------");
        return userMapper.getByName(user.getUsername());
    }

    @PostMapping("/user/add")
    public Result add(@RequestBody User user){
        log.info("-------------OK add User!-------------");
        Result result = new Result();
        if(userMapper.getByName(user.getUsername())!=null){
            result.setMsg(0);
            return result;
        } else if (user.getUsername().isEmpty() ||user.getPassword().isEmpty()) {
            result.setMsg(2);
            return result;
        }
        userMapper.add(user);
        result.setMsg(1);
        return result;
    }

    @PutMapping("/user/update")
    public void update(@RequestBody User user){
        log.info("-------------OK update User!-------------");
        userMapper.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id){
        log.info("-------------OK delete User!-------------");
        userMapper.delete(id);
    }

    @GetMapping("/user/getall")
    public List<User> getAllUser(){
        log.info("-------------OK searchAll User!-------------");
        return userMapper.getAllUser();
    }
}
