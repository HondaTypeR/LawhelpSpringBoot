package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Professor;
import com.it.lawhelp.spring.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    int addNewUser(User user);
    String selectIsPhone(String phone);
    List<User> login(@Param("phone") String phone, @Param("password") String password);
    int addprofessor(Professor professor);
    String selectIsProfessor(String assestid);
    List<User> findUserInfos(@Param("phone") String phone);
    List<Professor> findProfessors(@Param("phone") String phone);
}
