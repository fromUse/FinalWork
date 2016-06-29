package com.gui.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import com.gui.dao.UserDao;
import com.gui.entity.User;
import com.gui.utils.LocalSessionUtils;

/**
 * 
 * @author chen-gui
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public User findUserByuserName(String userName) {
		Session session = LocalSessionUtils.getSession();
		
		String hql = "from User where userName=?";
		List<User> users = session.createQuery(hql).setParameter(0, userName).list();
		//System.out.println(users);
		if(users.size()!=1){
			LocalSessionUtils.commit();
			return null;
		}else{
			LocalSessionUtils.commit();
		
			return users.get(0);
		}
	}

	@Test
	public void test(){
		
		System.out.println(findUserByuserName("chen"));
	}
}
