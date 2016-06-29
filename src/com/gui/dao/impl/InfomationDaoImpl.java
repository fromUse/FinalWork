package com.gui.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.gui.dao.InfomationDao;
import com.gui.entity.Infomation;
import com.gui.entity.User;
import com.gui.utils.LocalSessionUtils;

public class InfomationDaoImpl implements InfomationDao {

	@Override
	public List<Infomation> getAllInfo() {
		
		Session session = LocalSessionUtils.getSession();
		List<Infomation> infolist  = session.createQuery("from Infomation").list();
		LocalSessionUtils.commit();
		return infolist;
	}

	@Override
	public List<Infomation> getInfobyUser(User user) {
	
		Session session = LocalSessionUtils.getSession();
		Query hql = session.createQuery("from Infomation  where sid=" + user.getSid());
		List<Infomation> infolist  = hql.list();
		LocalSessionUtils.commit();
	
		return infolist;
	}

	
	@Test
	public void test(){
		User user =  new User();
		user.setSid(1);
		 List<Infomation> list =  getInfobyUser( user);
		System.out.println(list);
	}
	
	
	@Override
	public void deletInfo(Infomation info) {
		Session session = LocalSessionUtils.getSession();

		session.delete(info);
		LocalSessionUtils.commit();

	}

	@Override
	public void modifyInfo(Infomation info) {
		
			Session session = LocalSessionUtils.getSession();
		
		session.update(info);
		LocalSessionUtils.commit();
	}

	@Override
	public void addInfo(Infomation info) {
	Session session = LocalSessionUtils.getSession();
		
	session.save(info);
	LocalSessionUtils.commit();
		
	}

	@Override
	public Infomation getIndoById(int id) {
		
		Session session = LocalSessionUtils.getSession();
		
		Infomation info = (Infomation) session.get(Infomation.class, id);
		
		LocalSessionUtils.commit();
		
		return  info;
	}

}
