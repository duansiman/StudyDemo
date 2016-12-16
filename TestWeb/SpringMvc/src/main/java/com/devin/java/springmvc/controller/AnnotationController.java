package com.devin.java.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by devin on 2016/12/6.
 */
@Controller
public class AnnotationController {

    @RequestMapping(value = "/request")
    public void requestParam(@RequestParam Map<String, String> params){
        System.out.println(params);
    }

}
