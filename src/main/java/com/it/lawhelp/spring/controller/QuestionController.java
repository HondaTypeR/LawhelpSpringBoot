package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.QuestionMapper;
import com.it.lawhelp.spring.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired QuestionMapper questionMapper;
    @PostMapping("/add/question")
    public Boolean addQuestion(@RequestBody Question question){
    Boolean tag = questionMapper.addQuestion(question);
    return tag;
    }

}
