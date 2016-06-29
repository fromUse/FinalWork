package com.gui.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.gui.dao.LoginResult;
import com.gui.dao.UserLoginDao;
import com.gui.entity.User;
import com.gui.utils.LocalSessionUtils;

public class UserLogin implements UserLoginDao {

	@Override
	public LoginResult login(String userName, String passWord) {

		Session session = LocalSessionUtils.getSession();

		LoginResult loginResult = new LoginResult();

		List<User> users = session.createQuery("from User where userName='" + userName + "'").list();

		if (users.size() > 1 || users.size() == 0) {
			System.out.println(users);
			loginResult.setLoginSuccessed(false);
			loginResult.setErrorCode(LoginResult.NOTFOUND_USER);
		} else if (users.size() == 1) {
			User user = users.get(0);
			if (user.getPassWord().equals(passWord)) {
				loginResult.setLoginSuccessed(true);
				loginResult.setErrorCode(LoginResult.SUCCESS);
			}else{
				loginResult.setErrorCode(LoginResult.PASS_ERROR);
			}
		}

		LocalSessionUtils.commit();

		return loginResult;
	}

	@Test
	public void test() {
		LoginResult result = 	login("conykais1", "aaaaa");

		if(result.isLoginSuccessed()){
			System.out.println("登陆成功......");
		}else{
			switch (result.errorCode()) {
			case LoginResult.NOTFOUND_USER:
				System.out.println("用户不存在");
				break;
			case LoginResult.PASS_ERROR:
				System.out.println("密码错误");
				break;
			}
		}
	}

}
