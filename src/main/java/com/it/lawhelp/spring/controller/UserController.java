package com.it.lawhelp.spring.controller;
import com.it.lawhelp.spring.dao.UserMapper;
import com.it.lawhelp.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@RestController
public class UserController{
    @Autowired
    UserMapper userMapper;

    @GetMapping("/add/user/{phone}/{password}/{username}")
    public Object addUser(@PathVariable String phone, @PathVariable String password, @PathVariable String username, HttpServletResponse response) throws Exception {
    User user =new User();
        if(userMapper.selectIsPhone(phone)==null){
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setMsg("恭喜注册成功");
            userMapper.addNewUser(user);
            Result result = new Result(true,200,"成功",user);
            Json.toJson(result,response);
        }else {
            Result result = new Result(false,200,"成功",user);
            user.setMsg("该手机号已注册，请直接登陆");
            Json.toJson(result,response);
        }
        return user;
    }

}
