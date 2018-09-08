package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="app_users_tbl")
public class Users {
	
	@Id
	private String id;
	
	//用户名称
	@Column(name = "NICK_NAME")
	private String name;	
	//电话号码
	@Column(name="PHONE")
	private String phone;
	//验证码
	@Column(name="CODE")
	private String code;
	//统计用户使用次数
	@Column(name="COUNTNUM")
	private int countNum;
	
	//跟新时间
	@Column(name="updatetime")
	private String update;
	
	//创建时间
	@Column(name="creationtime")
	private String createDate;
	
	public Users(){}
	
	public Users(String name, String phone, String code, int countNum, String update,String createDate) {
		this.name = name;
		this.phone = phone;
		this.code = code;
		this.countNum = countNum;
		this.update = update;
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
	
	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
