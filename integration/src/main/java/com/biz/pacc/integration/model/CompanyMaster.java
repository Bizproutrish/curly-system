package com.biz.pacc.integration.model;


public class CompanyMaster {
	
	private int comp_id;
	private String company_code;
	private String company_name;
	private int username_logic;
	private String db_name;
	private int active_status;
	
	
	
	public CompanyMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompanyMaster(String company_code, String company_name, int username_logic, String db_name,
			int active_status) {
		super();
//		this.comp_id = comp_id;
		this.company_code = company_code;
		this.company_name = company_name;
		this.username_logic = username_logic;
		this.db_name = db_name;
		this.active_status = active_status;
	}
	
	
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getUsername_logic() {
		return username_logic;
	}
	public void setUsername_logic(int username_logic) {
		this.username_logic = username_logic;
	}
	public String getDb_name() {
		return db_name;
	}
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}
	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
	
	

}
