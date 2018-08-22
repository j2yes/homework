package com.wmp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmp.services.StringService;

@RestController
public class StringController {

	@Autowired
	private StringService stringService;
	
	@GetMapping("/string")
    public Map<String, Integer> calcString(@RequestParam String inputText, @RequestParam(defaultValue="1") int unit) {
        Map<String, Integer> resultMap = stringService.calcString(inputText, unit);
        return resultMap;
    }
}