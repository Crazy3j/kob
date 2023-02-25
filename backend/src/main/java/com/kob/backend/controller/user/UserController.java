package com.kob.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ultraman
 * @Date 2023/2/25 23:33
 * @Version 1.0
 */

@RestController
public class UserController {

    @Resource // 匹配注入，默认byName
    UserMapper userMapper;
    @GetMapping("/user/all/")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }
    @GetMapping("/user/{userId}/")
    public User getuser(@PathVariable int userId){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return userMapper.selectOne(queryWrapper);
    }
    @GetMapping("/user/add/{userId}/{username}/{password}/")
    public String addUser(@PathVariable int userId,
                          @PathVariable String username,
                          @PathVariable String password){
        // if(password.length()< 6) return "密码太短";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);
        User user= new User(userId,username,encodePassword);
        userMapper.insert(user);
        return "Add User Successfully";
    }

    @GetMapping("/user/delete/{userId}/")
    public String deleteUser(@PathVariable int userId){
        userMapper.deleteById(userId);
        return "Delete User successfully";
    }
}
