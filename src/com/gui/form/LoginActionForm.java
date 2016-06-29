package com.gui.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 * @author chenq
 *
 *这个类是一个封装类，
 *即javabean 例如封装一个表单的相关数据
 *Struts会自动把表单的字符串转换成实际的数据类型
 *
 *类字段必须为private
 *并且提供public的setXXX/getXXX方法
 *
 */

@SuppressWarnings("serial")
public class LoginActionForm extends ActionForm
{
	private String userName;
	private String passwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	
	
	
}
