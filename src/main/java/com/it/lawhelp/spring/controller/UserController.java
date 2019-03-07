package com.it.lawhelp.spring.controller;
import com.it.lawhelp.spring.dao.UserMapper;
import com.it.lawhelp.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "pic")
    public User pic(){
        User user = userMapper.selectUserByName();
        return user;
    }
    @RequestMapping(value = "li")
    public List li(){
        List<User> users =userMapper.getUsers();
        return users;
    }
}
