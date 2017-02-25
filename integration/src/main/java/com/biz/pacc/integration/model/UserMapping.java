package com.biz.pacc.integration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="common_user_mapping")
public class UserMapping {
	
	@Id
	@Column(name="user_id")
	private int user_id;
	@Column(name="app_username")
	private String app_username;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getApp_username() {
		return app_username;
	}

	public void setApp_username(String app_username) {
		this.app_username = app_username;
	}

}
