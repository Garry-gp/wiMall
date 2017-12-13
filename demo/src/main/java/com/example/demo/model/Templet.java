package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_templet_tbl")
public class Templet {
	
	@Id
	String id;
	@Column(name ="address")
	String address;
	//短信内容
	@Column(name ="content")
	String content;
	//账号密码
	@Column(name ="password")
	String password;
	//账号ID
	@Column(name ="userid")
	String userId;
	
	public Templet() {}
	
	public Templet( String address, String content, String password, String userId) {
		this.address = address;
		this.content = content;
		this.password = password;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
