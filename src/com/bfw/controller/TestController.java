package com.bfw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/test.do")
	public String test(){
		
		System.out.println("-----我是控制器-----");
		
		return "index";
	}
	
}
