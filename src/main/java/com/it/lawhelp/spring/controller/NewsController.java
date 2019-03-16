package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
    @Autowired
    NewsMapper newsMapper;
    @GetMapping("/find/news")
    public Object findNews(){
        return newsMapper.findNews();
    }
    @GetMapping("/find/newsById/{id}")
    public Object findNewsById(@PathVariable Integer id){
        return newsMapper.findNewsById(id);
    }

}
