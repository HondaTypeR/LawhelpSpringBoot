package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Img;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface ImgMapper {
    Boolean test(Img img);
    List<Img> findimg(Integer id);
    Boolean addimg (Img img);
}
