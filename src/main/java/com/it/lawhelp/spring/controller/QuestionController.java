package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.QuestionMapper;
import com.it.lawhelp.spring.vo.Part;
import com.it.lawhelp.spring.vo.ProfessorRes;
import com.it.lawhelp.spring.vo.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class QuestionController {
    @Autowired QuestionMapper questionMapper;
    @PostMapping("/add/question")
    public Boolean addQuestion(@RequestBody Question question){
    Boolean tag = questionMapper.addQuestion(question);
    return tag;
    }
    @GetMapping("/find/questions")
    public Object findQuestions(){
        return questionMapper.findQuestion();
    }
    @GetMapping("/find/questions/{id}")
    public Object findQuestionsById(@PathVariable("id") Integer id){
        return questionMapper.findQuestionById(id);
    }
    @GetMapping("find/professorRes/{parentId}")
    public Object findProfessorRes(@PathVariable("parentId") Integer parentId){
        return  questionMapper.findProfessorRes(parentId);
    }
    @PostMapping("/add/professorres")
    public Boolean addProfessorRes(@RequestBody ProfessorRes professorRes){
        Boolean tag = questionMapper.addProfessorRes(professorRes);
        return  tag;
    }


}
