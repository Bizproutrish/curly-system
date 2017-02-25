package com.biz.pacc.integration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="common_login_user_master")
public class LoginUser {
	@Id
	@Column(name="user_id")
	private int user_id;
	@Column(name="login_username")
	private String userName;
	@Column(name="pwd")
	private String password;
	@Column(name="mac_id")
	private String mac_id;
	@Column(name="ip_addr")
	private String ip_add;
	@Column(name="user_type")
	private int usr_typ;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMac_id() {
		return mac_id;
	}
	public void setMac_id(String mac_id) {
		this.mac_id = mac_id;
	}
	public String getIp_add() {
		return ip_add;
	}
	public void setIp_add(String ip_add) {
		this.ip_add = ip_add;
	}
	public int getUsr_typ() {
		return usr_typ;
	}
	public void setUsr_typ(int usr_typ) {
		this.usr_typ = usr_typ;
	}
	
		
}
