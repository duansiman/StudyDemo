package com.devin.java.springmvc.controller;

import com.devin.java.springmvc.bean.User;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by devin on 2016/12/6.
 */
@Controller
@RequestMapping(value = "/test")
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello()
    {
        /*forward前缀浏览器不知道URL被换了，redirect可以知道URL被换了 */
        return "redirect:/test/world";
    }

    @RequestMapping(value = "/world")
    public String world(){
        return "world";
    }

    /*{name}模板 @PathVariable 得到模板值*/
    @RequestMapping(value = "/hello/{name}", consumes = "application/json")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return String.format("hello %s, welcome", name);
    }

}
