package com.wmp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Value("${wmp.hello}")
    private String hello;

    @RequestMapping("/")
    public String index(ModelMap model) {
    	model.addAttribute("hello", hello);
        return "index";
    }
}