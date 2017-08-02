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
		
//		System.out.println("------业务逻辑层----------");
		
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
	
	@Override
	public UserInfo getUser(Integer userId) throws Exception {
		if(userId!=null){
			UserInfo user=userInfoMapper.getUser(userId);		
			return user;
		}
		return null;
	}

	@Override
	public boolean updateUser(UserInfo user) {
		if(user!=null){
			int count=userInfoMapper.updateUser(user);
			if(count>0)
				return true;
		}
		
		return false;
	}

	@Override
	public boolean deleterUser(Integer[] userIds) {
		if(userIds.length>0){
		for(Integer userId:userIds){
			userInfoMapper.delUser(userId);
		}
		return true;
		}
		return false;
	}
}
