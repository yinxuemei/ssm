package com.bfw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.mapper.UserInfoMapper;
import com.bfw.po.UserInfo;
import com.bfw.service.UserInfoService;

/**
 * @Service  默认bean名称userInfoServiceImpl
 * @author Administrator
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Resource(name="userInfoMapper")
	private UserInfoMapper userInfoMapper;

	@Override
	public boolean addUser(UserInfo user) {
		
		System.out.println("------业务逻辑层----------");
		
		int count = userInfoMapper.addUser(user);
		
		if(count>0){
			return true;
		}
		
		return false;
	}

	@Override
	public List<UserInfo> getUserList(UserInfo user) {
		// TODO Auto-generated method stub
		// 模糊查询
		if(user!=null){
			
			if(user.getUserName()!=null && !user.getUserName().equals("")){
				
				user.setUserName("%"+user.getUserName()+"%");
			}
		}
		
		List<UserInfo> list=userInfoMapper.getUserList(user);
		return list;
	}

}
