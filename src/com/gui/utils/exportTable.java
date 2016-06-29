package com.gui.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class exportTable {
	/**
	 * 到出表结构
	 */
	@Test
	public void export() {

		/** 获取配置对象 **/
		Configuration config = new Configuration().configure();
		/** 获取服务注册对象 **/
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();

		SchemaExport export = new SchemaExport(config);

		export.create(true, true);
	}
}
