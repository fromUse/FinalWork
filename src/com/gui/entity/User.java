package com.gui.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "stuShell")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6505647698619218747L;

	@Id
	@GeneratedValue
	private int sid;

	@Column(length = 16, unique = true)
	private String userName;

	@Column(nullable = false)
	private String passWord;

	@Column(columnDefinition = "tinyint default 0")
	private int age;

	@Column(columnDefinition = "varchar(2) default '男'")
	private String sex = "男";

	@Column(nullable = false, columnDefinition = "varchar(255) default 'default.jpg'")
	private String picture = "default.jpg";

	@Override
	public String toString() {
		return "User [sid=" + sid + ", userName=" + userName + ", passWord="
				+ passWord + ", age=" + age + ", sex=" + sex + ", picture="
				+ picture + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User() {

	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public User(String userName, String passWord, String sex) {
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
	}

}
