package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;

import com.gui.entity.User;

public class UserTest {

	/** 会话工厂 **/
	private SessionFactory sessionFactory;
	/** 回=会话对象 **/
	private Session session;
	/** 事务对象 **/
	private Transaction transaction;

	/**
	 * 之前执行
	 * 
	 * 进行初始化操作
	 */
	@Before
	public void before() {

		/** 获取配置对象 **/
		Configuration config = new Configuration().configure();
		/** 获取服务注册对象 **/
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();

		// SchemaExport export = new SchemaExport(config);

	//	 export.create(true, true);

		/** 生成会话工厂对象 **/
		sessionFactory = config.buildSessionFactory(service);
		/** 获取会话对象 单例模式 **/
		session = sessionFactory.getCurrentSession();
		/** 获取事务对象 **/
		transaction = session.beginTransaction();

	}

	/**
	 * 之后执行 进行流的关闭,资源的释放
	 */

	@After
	public void after() {
		/** 提交事务 **/
		transaction.commit();
		/** 释放资源 **/
	//	session.close();
		/** 关闭会话工厂 **/
		sessionFactory.close();
	}

	/**
	 * 正在执行
	 */
	@org.junit.Test
	public void queryTest() {

		// User u = (User) session.get(User.class, 6);

		List<User> list = session.createQuery(
				"from User where userName like '%con%'").list();
		for (User user : list) {
			System.out.println(user);
		}
		// System.out.println(u);
	}

	@org.junit.Test
	public void deleteTest() {

	//	User u = (User) session.get(User.class, 1);
	//	session.delete(u);

		int i = session.createQuery("delete from User").executeUpdate();
		System.out.println(i);
	}

	@org.junit.Test
	public void updateTest() {

		User u = (User) session.get(User.class, 7);

		u.setUserName("c1ony1kais");
		session.update(u);

	}

	@org.junit.Test
	public void insertTest() {
		User a = new User();
		a.setUserName("conykais");
		a.setPassWord("123456");
		// a.setPicture("aaaa.jpg");
		a.setSex("男");
		a.setAge(20);
		session.save(a);
	}

	@org.junit.Test
	public void test() {

	}
}
