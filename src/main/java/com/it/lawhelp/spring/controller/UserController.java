package com.it.lawhelp.spring.controller;
import com.it.lawhelp.spring.dao.UserMapper;
import com.it.lawhelp.spring.vo.Img;
import com.it.lawhelp.spring.vo.Professor;
import com.it.lawhelp.spring.vo.User;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController{
    @Autowired
    UserMapper userMapper;
    @GetMapping("/add/user/{phone}/{username}/{password}/{role}/{balance}/{total}")
    public Object regin(@PathVariable String phone, @PathVariable String username, @PathVariable String password,
                        @PathVariable Integer role,@PathVariable String balance, @PathVariable Integer total, HttpServletResponse response) throws Exception {
    User user =new User();
        if(userMapper.selectIsPhone(phone)==null){
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            user.setBalance(balance);
            user.setTotal(total);
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
        if(userMapper.login(phone,password)==null){
            Result result = new Result(false,200,"成功",userMapper.login(phone,password));
            Json.toJson(result,response);
        }else{
            Result result = new Result(true,200,"成功",userMapper.login(phone,password));;
            Json.toJson(result,response);
        }
        return userMapper.login(phone,password);
    }
    @GetMapping("find/userinfos/{phone}")
    public Object findUserInfos (@PathVariable String phone,HttpServletResponse response) throws Exception {
        Result result = new Result(true,200,"成功",userMapper.findUserInfos(phone));
        Json.toJson(result,response);
        return userMapper.findUserInfos(phone);
    }
    @GetMapping("add/professor/{phone}/{name}/{idcard}/{assestid}/{unit}/{duty}/{goodat}/{address}/{email}/{parentId}")
    public Object addProfessor(@PathVariable String phone,@PathVariable String name,@PathVariable String idcard,@PathVariable String assestid,
                               @PathVariable String unit,@PathVariable String duty,@PathVariable String goodat,
                               @PathVariable String address,@PathVariable String email,@PathVariable Integer parentId, HttpServletResponse response) throws Exception {
        Professor professor = new Professor();
        if(userMapper.selectIsProfessor(assestid)==null){
            professor.setPhone(phone);
            professor.setName(name);
            professor.setIdcard(idcard);
            professor.setAssestid(assestid);
            professor.setUnit(unit);
            professor.setDuty(duty);
            professor.setGoodat(goodat);
            professor.setAddress(address);
            professor.setEmail(email);
            professor.setParentId(parentId);
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
    @GetMapping("/find/professors/{phone}")
    public Object findProfessor(@PathVariable String phone){
      return   userMapper.findProfessors(phone);
    }
    @GetMapping("/find/hotprofessor/{parentId}")
    public Object findHotProfessor(@PathVariable("parentId") int parentId){

        return userMapper.findHotProfessor(parentId);
    }
    @GetMapping("/find/hotprofessor/{phone}/{parentId}")
    public Object findHotProfessorById(@PathVariable("phone") String phone,@PathVariable("parentId") int parentId){
        return userMapper.findHotProfessorById(phone,parentId);
    }
    @GetMapping("/update/total/{total}/{phone}")
    public Boolean updateTotal(@PathVariable("total") Integer total, @PathVariable("phone") String phone){
        User user=new User();
        user.setTotal(total);
        user.setPhone(phone);
        Boolean tag=userMapper.updateTotal(user);
        return  tag;
    }
    @PostMapping("/update/userinfo")
    public Object updateUserInfo(@RequestBody User user){
        return userMapper.updateUserInfo(user);
    }
}
