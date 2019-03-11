package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionMapper {
    Boolean addQuestion(Question question);
}
