package com.wmp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Value("${wmp.hello}")
    private String hello;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return hello;
    }
}