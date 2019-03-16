package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.PeopleMapper;
import com.it.lawhelp.spring.vo.PeopleRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeopleResController {
    @Autowired
    PeopleMapper peopleMapper;
    @GetMapping("/find/peopleres/{parentid}")
    public Object findPeopleRes(@PathVariable Integer parentid){
      return   peopleMapper.findPeopleRes(parentid);
    }
    @PostMapping("/add/peopleres")
    public Boolean addPeopleRes(@RequestBody PeopleRes peopleRes){
        Boolean tag = peopleMapper.addPeopleRes(peopleRes);
        return tag;
    }
}
