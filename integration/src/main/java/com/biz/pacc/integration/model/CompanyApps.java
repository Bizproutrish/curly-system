package com.biz.pacc.integration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comp_app_mapping")
public class CompanyApps {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int comp_map_id;
	@Column
	private int comp_id;
	@Column
	private int app_id;
	@Column
	private String app_url;
	@Column
	private String db_name;
	@Column
	private int biz_admin_user_id;
	@Column
	private Date active_from;
	@Column
	private Date active_to;
	@Column
	private int mac_req;
	@Column
	private int ip_req;
	@Column
	private String under_maint;
	@Column
	private int active_status;
	
	public CompanyApps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyApps(int comp_map_id, int comp_id, int app_id, String app_url, String db_name,
			int biz_admin_user_id, Date active_from, Date active_to, int mac_req, int ip_req, String under_maint,
			int active_status) {
		super();
		this.comp_map_id = comp_map_id;
		this.comp_id = comp_id;
		this.app_id = app_id;
		this.app_url = app_url;
		this.db_name = db_name;
		this.biz_admin_user_id = biz_admin_user_id;
		this.active_from = active_from;
		this.active_to = active_to;
		this.mac_req = mac_req;
		this.ip_req = ip_req;
		this.under_maint = under_maint;
		this.active_status = active_status;
	}

	public int getComp_map_id() {
		return comp_map_id;
	}

	public void setComp_map_id(int comp_map_id) {
		this.comp_map_id = comp_map_id;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public String getApp_url() {
		return app_url;
	}

	public void setApp_url(String app_url) {
		this.app_url = app_url;
	}

	public String getDb_name() {
		return db_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public int getBiz_admin_user_id() {
		return biz_admin_user_id;
	}

	public void setBiz_admin_user_id(int biz_admin_user_id) {
		this.biz_admin_user_id = biz_admin_user_id;
	}

	public Date getActive_from() {
		return active_from;
	}

	public void setActive_from(Date active_from) {
		this.active_from = active_from;
	}

	public Date getActive_to() {
		return active_to;
	}

	public void setActive_to(Date active_to) {
		this.active_to = active_to;
	}

	public int getMac_req() {
		return mac_req;
	}

	public void setMac_req(int mac_req) {
		this.mac_req = mac_req;
	}

	public int getIp_req() {
		return ip_req;
	}

	public void setIp_req(int ip_req) {
		this.ip_req = ip_req;
	}

	public String getUnder_maint() {
		return under_maint;
	}

	public void setUnder_maint(String under_maint) {
		this.under_maint = under_maint;
	}

	public int getActive_status() {
		return active_status;
	}

	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
	
	
	
	
	
	
	

}
