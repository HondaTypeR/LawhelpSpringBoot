package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.ImgMapper;
import com.it.lawhelp.spring.vo.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImgController {
    @Autowired
    ImgMapper imgMapper;
    @PostMapping("/add/img")
    public Boolean test(@RequestBody Img img){
        Boolean tag =imgMapper.test(img);
        return tag;
    }
    @GetMapping("/find/img/{id}")
    public Object findimg(@PathVariable("id") Integer id){
        return imgMapper.findimg(id);
    }
    @PostMapping("/add/imgs")
    public Boolean addImgs(@RequestBody Img img){
        Boolean tar=imgMapper.addimg(img);
        return  tar;
    }
}
