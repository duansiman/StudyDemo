package com.devin.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Created by devin on 2016/12/20.
 */
@Controller
public class HandlerExceptionContoller {

//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "server error 222222")
    @RequestMapping(value = "/exception")
    @ResponseBody
    public void throwIOException() throws IOException {
        throw new IOException();
//        return "body";
    }

//    @RequestMapping(value = "/error")
//    @ResponseBody
//    public String handlerException(Exception ex){
//        ex.printStackTrace();
//        return "error";
//    }
//
//    @ExceptionHandler(value = IOException.class)
//    @ResponseBody
//    public String handlerException(IOException e){
//        System.out.println("handlerException");
//        return "handler success";
//    }

}
