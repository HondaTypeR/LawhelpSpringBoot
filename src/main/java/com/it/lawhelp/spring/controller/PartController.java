package com.it.lawhelp.spring.controller;

import com.it.lawhelp.spring.dao.PartMapper;
import com.it.lawhelp.spring.vo.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class PartController {
    @Autowired
    PartMapper partMapper;
    @GetMapping("/find/city/{province}")
    public Object findCity(@PathVariable String province, HttpServletResponse response)throws Exception {
        Result result = new Result(true,200,"成功",partMapper.selectCity(province));
        Json.toJson(result,response);
        return  partMapper.selectCity(province);
    }
    @GetMapping("/find/province")
    public Object findProvince(HttpServletResponse response)throws Exception {
        Result result =new Result(true,200,"成功",partMapper.selectProvince());
        Json.toJson(result,response);
        return partMapper.selectProvince();
    }

}
