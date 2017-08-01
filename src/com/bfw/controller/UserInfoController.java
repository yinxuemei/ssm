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
	@RequestMapping("/add.do")
	public String add(UserInfo user,Model model){
		System.out.println(user+"oooooeeeeeeeeeeeeeeeeeeeeeeeeeee");
		boolean mark = false;
		try {
			
			mark = service.addUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mark){
			model.addAttribute("info", "用户信息添加成功！");
		}else{
			model.addAttribute("info", "用户信息添加失败！");
		}
		
		
		return "userinfo/user_info";
	}
	@RequestMapping("/loadUser.do")
	public String loadUser(Integer userId,Model model){
		System.out.println("编号"+userId);
		try {
			UserInfo user=service.getUser(userId);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "userinfo/user_update";
	}
	@RequestMapping("/update.do")
	public String update(UserInfo user,Model model){
		boolean mark=false;
		try {
			mark=service.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(mark){
			model.addAttribute("info", "用户信息修改成功！");
		}else{
			model.addAttribute("info", "用户信息修改失败！");
		}
		return "userinfo/user_info";
	}

}
