package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    List<News> findNews();
    List<News> findNewsById(Integer id);
}
