package com.bfw.service;

import java.util.List;

import com.bfw.po.UserInfo;

public interface UserInfoService {

	/**
	 * ����û���Ϣ
	 * @param user �û���Ϣ
	 * @return
	 */
	public boolean addUser(UserInfo user)throws Exception;
	/**
	 * 查询用户信息
	 * @param user查询条件
	 * @return
	 */
	public List<UserInfo> getUserList(UserInfo user);
	
	/**
	 * 根据编号查询用户信息
	 * @param userId查询条件
	 * @return
	 * @throws Exception
	 */
	public UserInfo getUser(Integer userId)throws Exception;
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(UserInfo user);
}
