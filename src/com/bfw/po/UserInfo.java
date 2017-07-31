package com.bfw.po;

import java.util.Date;

public class UserInfo {

	private Integer userId;

	private String userName;

	private Integer userAge;

	private String userSex;

	private Date userBrithday;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getUserBrithday() {
		return userBrithday;
	}

	public void setUserBrithday(Date userBrithday) {
		this.userBrithday = userBrithday;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", userAge=" + userAge + ", userSex=" + userSex
				+ ", userBrithday=" + userBrithday + "]";
	}

}
