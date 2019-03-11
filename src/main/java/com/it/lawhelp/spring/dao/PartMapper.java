package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface PartMapper {
    List<Part> selectCity(String province);
    List<Part> selectProvince();
}
