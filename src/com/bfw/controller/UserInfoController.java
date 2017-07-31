package com.bfw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.UserInfo;
import com.bfw.service.UserInfoService;

@Controller
@RequestMapping(value="/user")
public class UserInfoController {
	//业务逻辑层
	@Resource(name="userInfoServiceImpl")
	private UserInfoService service;
	
	@RequestMapping("/list.do")
	public String list(UserInfo user,Model model){
		 System.out.println(user);
		List<UserInfo>list=service.getUserList(user);
		model.addAttribute("list",list);
		
		return "userinfo/user_list";
	}

}
