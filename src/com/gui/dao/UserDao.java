package com.gui.dao;

import com.gui.entity.User;

public interface UserDao {
		User findUserByuserName(String userName);
}
