package com.ssh.demo.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass //作为Entity的基础服务类
public class BaseEntity <T extends Serializable>
{
	protected T id;
	
	protected String creater;
	protected Date createrTime;
	
	protected String updater;
	protected Date updateTime;
	
	
	private String remaker;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public T getId() {
		return id;
	}

	public String getCreater() {
		return creater;
	}

	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getCreaterTime() {
		return createrTime;
	}

	public String getUpdater() {
		return updater;
	}

	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public String getRemaker() {
		return remaker;
	}

	public void setId(T id) {
		this.id = id;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public void setCreaterTime(Date createrTime) {
		this.createrTime = createrTime;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setRemaker(String remaker) {
		this.remaker = remaker;
	}

	
	
	
	
}
