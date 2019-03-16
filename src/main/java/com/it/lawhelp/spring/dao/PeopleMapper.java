package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.PeopleRes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PeopleMapper {
    List<PeopleRes> findPeopleRes(Integer parentid);
    Boolean addPeopleRes(PeopleRes peopleRes);
}
