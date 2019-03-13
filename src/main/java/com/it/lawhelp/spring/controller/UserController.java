package com.it.lawhelp.spring.controller;
import com.it.lawhelp.spring.dao.UserMapper;
import com.it.lawhelp.spring.vo.Professor;
import com.it.lawhelp.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@RestController
public class UserController{
    @Autowired
    UserMapper userMapper;
    @GetMapping("/add/user/{phone}/{username}/{password}")
    public Object regin(@PathVariable String phone, @PathVariable String username, @PathVariable String password, HttpServletResponse response) throws Exception {
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
    @GetMapping("/find/user/{phone}/{password}")
    public Object login(@PathVariable String phone,@PathVariable String password,HttpServletResponse response) throws Exception {
        User user = new User();
        if(userMapper.login(phone,password)==null){
            Result result = new Result(false,200,"成功",user);
            user.setMsg("账号或密码有误，请重新输入");
            Json.toJson(result,response);
        }else{
            Result result = new Result(true,200,"成功",user);
            user.setMsg("登陆成功");
            Json.toJson(result,response);
        }
        return user;
    }
    @GetMapping("add/professor/{phone}/{name}/{idcard}/{assestid}/{unit}/{duty}/{goodat}")
    public Object addProfessor(@PathVariable String phone,@PathVariable String name,@PathVariable String idcard,@PathVariable String assestid,
                               @PathVariable String unit,@PathVariable String duty,@PathVariable String goodat, HttpServletResponse response) throws Exception {
        Professor professor = new Professor();
        if(userMapper.selectIsProfessor(assestid)==null){
            professor.setPhone(phone);
            professor.setName(name);
            professor.setIdcard(idcard);
            professor.setAssestid(assestid);
            professor.setUnit(unit);
            professor.setDuty(duty);
            professor.setGoodat(goodat);
            professor.setMsg("已提交成功，请耐心等待验证");
            userMapper.addprofessor(professor);
            Result result =new Result(true,200,"成功",professor);
            Json.toJson(result,response);
        }else{
            Result result =new Result(false,200,"成功",professor);
            professor.setMsg("该证件号已被验证，请确认");
            Json.toJson(result,response);
        }
        return  professor;
    }
}
