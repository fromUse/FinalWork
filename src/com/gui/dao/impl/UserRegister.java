package com.gui.dao.impl;

import org.hibernate.Session;

import com.gui.dao.UserRegisterDao;
import com.gui.entity.User;
import com.gui.utils.LocalSessionUtils;

public class UserRegister implements UserRegisterDao {

	@Override
	public boolean registerUser(User user) {
	
		
		Session session = LocalSessionUtils.getSession();
		
		try {
			session.save(user);
		} catch (Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();
		}finally{
			LocalSessionUtils.commit();
		}
		
		
	
		return false;
	}

}
