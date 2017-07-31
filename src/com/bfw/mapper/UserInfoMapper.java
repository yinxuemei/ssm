package com.bfw.mapper;

import java.util.List;

import com.bfw.po.UserInfo;

public interface UserInfoMapper {

	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return
	 */
	public int addUser(UserInfo user);
	/**
	 * 查询用户信息
	 * @param user查询条件
	 * @return返回用户信息
	 */
	public List<UserInfo> getUserList(UserInfo user);
	
}
