package com.it.lawhelp.spring.dao;

import com.it.lawhelp.spring.vo.Part;
import com.it.lawhelp.spring.vo.ProfessorRes;
import com.it.lawhelp.spring.vo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
    Boolean addQuestion(Question question);
    List<Part> findQuestion();
    List<Part> findQuestionById(String phone);
    List<Part> findQuestionByIds(Integer id);
    List<ProfessorRes> findProfessorRes(Integer parentId);
    Boolean addimg(Question question);
    Boolean addProfessorRes(ProfessorRes professorRes);
}
