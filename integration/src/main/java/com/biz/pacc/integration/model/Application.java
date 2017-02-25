package com.biz.pacc.integration.model;

import javax.persistence.Table;

@Table(name="common_application")
public class Application {
	private int app_Id;
	private String app_Name;
	private String user_table_ref_name;
	private int active_status;
	
	
	
	
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Application(int app_Id, String app_Name, String user_table_ref_name, int active_status) {
		super();
		this.app_Id = app_Id;
		this.app_Name = app_Name;
		this.user_table_ref_name = user_table_ref_name;
		this.active_status = active_status;
	}



	public int getApp_Id() {
		return app_Id;
	}
	public void setApp_Id(int app_Id) {
		this.app_Id = app_Id;
	}
	public String getApp_Name() {
		return app_Name;
	}
	public void setApp_Name(String app_Name) {
		this.app_Name = app_Name;
	}
	public String getUser_table_ref_name() {
		return user_table_ref_name;
	}
	public void setUser_table_ref_name(String user_table_ref_name) {
		this.user_table_ref_name = user_table_ref_name;
	}
	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
	
	
	

}
