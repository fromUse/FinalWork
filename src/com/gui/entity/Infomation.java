package com.gui.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Infomation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5037770929357856600L;
	@Id
	@GeneratedValue
	private int id;
	//@Id
	// private int uid;
	 @Column(nullable = false,unique=false,length=140)
	private String title;
	@Column(columnDefinition="text not null")
	private String content;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sid")
	private User user;
	@Column(nullable=false)
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Infomation [id=" + id + ",  title=" + title + ", content="
				+ content + "]";
	}

	public Infomation() {

	}

}
