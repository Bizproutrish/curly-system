package com.biz.pacc.integration.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.biz.pacc.integration.dao.DBConnection;
import com.biz.pacc.integration.model.Application;
import com.biz.pacc.integration.model.CompanyMaster;
import com.biz.pacc.integration.model.DB_Names;
import com.biz.pacc.integration.model.UserMapping;

public class CompanyService {
	
	public List<CompanyMaster> getAllCompanies(){
		List<CompanyMaster> list1= new ArrayList<>();
	
		try{
		DBConnection dbc = new DBConnection();
		Connection connection = dbc.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM companymaster");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		  CompanyMaster cmp= new CompanyMaster();
		  cmp.setComp_id(rs.getInt(1));
		  cmp.setCompany_code(rs.getString(2));
		  cmp.setCompany_name(rs.getString(3));
		  cmp.setUsername_logic(rs.getInt(4));
		  cmp.setDb_name(rs.getString(5));
		  cmp.setActive_status(rs.getInt(6));
		  list1.add(cmp);
		}
		System.out.println(list1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list1;
	} 
	
	public List<DB_Names> getAllDatabases(){
		List<DB_Names> dbList= new ArrayList<>();
	
		try{
		DBConnection dbc = new DBConnection();
		Connection connection = dbc.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT Desktop_db_name FROM db_names where active_status="+1);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			DB_Names cmp= new DB_Names();
			cmp.setDesktop_db_name(rs.getString(1));
			dbList.add(cmp);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return dbList;
	} 
	
	public List<Application> getAllApps(){
		List<Application> appsList= new ArrayList<>();
	
		try{
		DBConnection dbc = new DBConnection();
		Connection connection = dbc.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT app_id,app_name FROM common_application");	// where active_status="+0);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Application apps= new Application();
			apps.setApp_Id(rs.getInt(1));
			apps.setApp_Name(rs.getString(2));
			appsList.add(apps);
			System.out.println(rs.getString(2));
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return appsList;
	} 	
	
	
	public CompanyMaster getCmpName(int cmpId){
		  
		CompanyMaster cmp= new CompanyMaster();
		try{
		DBConnection dbc = new DBConnection();
		Connection connection = dbc.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM companymaster where comp_id="+cmpId);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
		  cmp.setComp_id(rs.getInt(1));
		  cmp.setCompany_code(rs.getString(2));
		  cmp.setCompany_name(rs.getString(3));
		  cmp.setUsername_logic(rs.getInt(4));
		  cmp.setDb_name(rs.getString(5));
		  cmp.setActive_status(rs.getInt(6));
		  System.out.println(rs.getString(2));
		  
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return cmp;
	} 
	
	public CompanyMaster addCompany(String cmpId,String cmpName,int cmpLogicId,String dbName){
		CompanyMaster cmp= new CompanyMaster();
		try{
		DBConnection dbc = new DBConnection();
		Connection conn= dbc.getConnection();
		/*Statement st= conn.createStatement();
		st.executeQuery("select max")*/
		PreparedStatement ps = conn.prepareStatement("INSERT INTO company_master(company_code,company_name,username_logic,db_name) VALUES"
		+ "(?,?,?,?)");
		
		  ps.setString(1,cmpId);
		  ps.setString(2,cmpName);
		  ps.setInt(3,cmpLogicId);
		  ps.setString(4,dbName);
		  ps.executeUpdate();
		  
		  cmp.setDb_name(dbName);
		  cmp.setCompany_code(cmpId);
		  cmp.setCompany_name(cmpName);
		  cmp.setActive_status(0);
		  cmp.setUsername_logic(0);
		  
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cmp;
	} 
		
	}
