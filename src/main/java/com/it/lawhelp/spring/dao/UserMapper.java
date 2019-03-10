package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Professor;
import com.it.lawhelp.spring.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface UserMapper {
    int addNewUser(User user);
    String selectIsPhone(String phone);
    String login(@Param("phone") String phone,@Param("password") String password);
    int addprofessor(Professor professor);
    String selectIsProfessor(String assestid);
}
