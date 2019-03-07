package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    User selectUserByName();
    List<User>  getUsers();
}
