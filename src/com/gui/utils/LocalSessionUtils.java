package com.gui.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class LocalSessionUtils {

	/** 会话工厂 **/
	private static SessionFactory sessionFactory;
	/** 回=会话对象 **/
	private static Session session;
	/** 事务对象 **/
	private static Transaction transaction;

	public static Session getSession() {

		/** 获取配置对象 **/
		Configuration config = new Configuration().configure();
		/** 获取服务注册对象 **/
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		/** 生成会话工厂对象 **/
		sessionFactory = config.buildSessionFactory(service);
		/** 获取会话对象 单例模式 **/
		session = sessionFactory.openSession();
		/** 获取事务对象 **/
		transaction = session.beginTransaction();
		return session;

	}

	/**
	 * 提交事務
	 */
	public static void commit() {
		/** 提交事务 **/
			transaction.commit();
			/** 释放资源 **/
			//session.close();
			/** 关闭会话工厂 **/
			sessionFactory.close();

	}

}
