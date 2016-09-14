package com.ssh.demo.entity;

import javax.persistence.Entity;

import com.ssh.demo.util.BaseEntity;


/**
 * 用户对象  :Entity 类  /JavaBean
 * 1.私有的属性
 * 2.公共的get/set方法
 */
@Entity
public class User extends BaseEntity<Long>
{
	//列
	private String userName;
	private String password;
	
	//关联关系
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ",userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
