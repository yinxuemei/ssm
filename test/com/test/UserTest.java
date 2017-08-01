package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bfw.po.UserInfo;
import com.bfw.service.UserInfoService;

public class UserTest {

	@Test
	public void addUser()throws Exception{
		
		//加载applicationContext.xml 配置文件  在上下文中获取BEAN
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserInfoService service = (UserInfoService)context.getBean("userInfoServiceImpl");
		
		UserInfo user = new UserInfo();
		user.setUserId(40);
		user.setUserName("张三3");
		user.setUserAge(18);
		user.setUserSex("保密");
		
		
		boolean mark = service .addUser(user);
		
		if(mark){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	@Test
	public void selectUser(){
		//加载applicationContext.xml 配置文件  在上下文中获取BEAN
				ApplicationContext context = new ClassPathXmlApplicationContext(
						"applicationContext.xml");
				UserInfoService service = (UserInfoService)context.getBean("userInfoServiceImpl");
				List<UserInfo> list=service.getUserList(null);
				for(UserInfo user:list){
					System.out.println(user);
				}
	}
}
