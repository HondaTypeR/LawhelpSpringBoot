package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface UserMapper {
    int addNewUser(User user);
    String selectIsPhone(String phone);
}
