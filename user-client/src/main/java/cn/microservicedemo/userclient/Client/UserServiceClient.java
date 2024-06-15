package cn.microservicedemo.userclient.Client;

import cn.microservicedemo.userclient.model.Result;
import cn.microservicedemo.userclient.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="user-service")
public interface UserServiceClient {
    @PostMapping("/user/search")
    User getByName(@RequestBody User user);

    @PostMapping("/user/add")
    Result add(@RequestBody User user);

    @PutMapping("/user/update")
    void update(@RequestBody User user);

    @DeleteMapping("/user/{id}")
    void delete(@PathVariable(value = "id") int id);

    @GetMapping("/user/getall")
    List<User> getAllUser();
}
