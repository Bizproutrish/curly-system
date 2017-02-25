package com.biz.pacc.integration.model;

import javax.persistence.Table;

@Table(name="db_names")
public class DB_Names {

private int cust_id;
private String cust_name;
private int active_status;
private int existing_db;
private String company_id;
private String desktop_db_name;



public DB_Names() {
	super();
}


public DB_Names(int cust_id, String cust_name, int active_status, int existing_db, String company_id,
		String desktop_db_name) {
	super();
	this.cust_id = cust_id;
	this.cust_name = cust_name;
	this.active_status = active_status;
	this.existing_db = existing_db;
	this.company_id = company_id;
	this.desktop_db_name = desktop_db_name;
}


public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public String getCust_name() {
	return cust_name;
}
public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}
public int getActive_status() {
	return active_status;
}
public void setActive_status(int active_status) {
	this.active_status = active_status;
}
public int getExisting_db() {
	return existing_db;
}
public void setExisting_db(int existing_db) {
	this.existing_db = existing_db;
}
public String getCompany_id() {
	return company_id;
}
public void setCompany_id(String company_id) {
	this.company_id = company_id;
}
public String getDesktop_db_name() {
	return desktop_db_name;
}
public void setDesktop_db_name(String desktop_db_name) {
	this.desktop_db_name = desktop_db_name;
}




}

