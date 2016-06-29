package com.gui.form;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class RegisterActionForm extends ActionForm {

	private FormFile img;
	private String userName;
	private String passWord;
	private String notPassword;
	private String sex;
	private String code;
	public FormFile getImg() {
		return img;
	}
	public void setImg(FormFile img) {
		this.img = img;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNotPassword() {
		return notPassword;
	}
	public void setNotPassword(String notPassword) {
		this.notPassword = notPassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "RegisterActionForm [  userName=" + userName
				+ ", passWord=" + passWord + ", notPassword=" + notPassword
				+ ", sex=" + sex + ", code=" + code + "]";
	}
	
}
