package com.devin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by devin on 2016/12/19.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String hello(){
        return "index";
    }

}
