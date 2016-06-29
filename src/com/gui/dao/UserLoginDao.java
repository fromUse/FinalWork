package com.gui.dao;

public interface UserLoginDao {

	/**
	 * 用户登陆
	 */
	LoginResult login(String userName,String passWord);
}
