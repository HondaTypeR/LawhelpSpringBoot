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

    @GetMapping("/add/user/{username}/{password}/{phone}/{role}")
    public Object addUser(@PathVariable String username, @PathVariable String password, @PathVariable String phone, @PathVariable Integer role, HttpServletResponse response) throws Exception {
    User user =new User();
        if(userMapper.selectIsName(username)==null){
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setRole(role);
            user.setMsg("恭喜注册成功");
            userMapper.addNewUser(user);
            Result result = new Result(true,200,"成功",user);
            Json.toJson(result,response);
        }else {
            Result result = new Result(false,200,"成功",user);
            user.setMsg("该用户名已存在，请重新输入");
            Json.toJson(result,response);
        }
        return user;
    }

}
