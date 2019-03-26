package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.CaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {
    @Autowired CaseMapper caseMapper;
    @GetMapping("/find/case/{id}")
    public Object findCase(@PathVariable("id") int ID){
        return  caseMapper.selectCase(ID);
    }
    @GetMapping("/find/allcase/{parentId}/{currPage}/{pageSize}")
    public Object findAllCase(@PathVariable("parentId") int parentId,@PathVariable("currPage") int currPage,@PathVariable("pageSize") int pageSize){
        return  caseMapper.selectAllCase(parentId,currPage,pageSize);
    }

}
