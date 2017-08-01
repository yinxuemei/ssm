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
	/**
	 * 根据编号查询用户信息
	 * @param userId查询条件
	 * @return
	 */
	public UserInfo getUser(Integer userId); 
	/**
	 * 用户信息修改
	 * @param user
	 * @return返回影响的行数
	 */
	public int updateUser(UserInfo user);
}
