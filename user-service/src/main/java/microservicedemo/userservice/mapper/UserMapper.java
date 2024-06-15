package microservicedemo.userservice.mapper;

import microservicedemo.userservice.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getByName(String username);

    @Update("update user set username = #{username},password = #{password},phone = #{phone},gender = #{gender} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int id);

    @Insert("insert into user(username, password, phone, gender) VALUES (#{username},#{password},#{phone},#{gender})")
    void add(User user);

    @Select("select * from user")
    List<User> getAllUser();

}
