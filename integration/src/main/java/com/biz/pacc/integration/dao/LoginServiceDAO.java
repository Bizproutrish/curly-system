package com.biz.pacc.integration.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.eclipse.persistence.annotations.Cache;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.OrderBy;

import com.biz.pacc.integration.model.Application;
import com.biz.pacc.integration.model.CompanyApps;
import com.biz.pacc.integration.model.LoginUser;
import com.biz.pacc.integration.model.UserMapping;
import com.biz.pacc.integration.resources.GetIpMac;

public class LoginServiceDAO {
		
		public LoginUser getLogUserDetails(String uname,String pass, String c_ip, String c_mac){
				
        Session session = SessionUtil.getSession();
        
        //String hql="select * from LoginUser log where log.login_username=:abdul.hafeez";
        Query query = session.createQuery("from LoginUser where userName=:loguser");
        query.setCacheable(false);
        query.setParameter("loguser", uname);
        
        LoginUser user=  (LoginUser) query.uniqueResult();
        session.evict(user);
        session.refresh(user);
        session.flush();
        session.close();
        URI uri,uri2;		 
		 
        System.out.println(c_mac);
		 System.out.println(user.getMac_id());
        
		// try {
			  
			  if(user.getUsr_typ()==4 && user.getPassword().equals(pass)){// && user.getIp_add().equalsIgnoreCase(ip) && user.getMac_id().equalsIgnoreCase(mac)){
				  System.out.println("****************************");
				 /* System.out.println(user.getPassword());
				  System.out.println(user.getMac_id());
				  System.out.println(user.getIp_add());*/
				  return user;
			  }
			  else if((user.getUsr_typ()==1 || user.getUsr_typ()==2) && user.getPassword().equals(pass) && user.getIp_add().equals(c_ip) && user.getMac_id().equals(c_mac)){
				  System.out.println("Else if cond..........");
				  return user;
			  }
			  else{
				  return null;
			  }
		}
			 		
//			  uri = new URI("http://localhost:9092/integration/landingpage.html");//("http://192.168.3.136:8080/BizLMS/bizint.php?app=LMS");
						//  Response.status(200).entity("user successfully login").build();
		  //	  } catch (Exception e) {	//(URISyntaxException e) {
				
		//		e.printStackTrace();
		//	}
			 
	
		
/*	public UserMapping getUserMapDetails(String user)
	{
		Session sess= SessionUtil.getSession();
		
		Query qry=sess.createQuery("from UserMapping where user_id=12299");//left join UserMapping on UserMapping.user_id=LoginUser.user_id where userName=:loguser
		//qry.setParameter("loguser", user);
		UserMapping um=  (UserMapping) qry.uniqueResult();
        sess.close();		
		return um;		
	}*/
		
		private void elseif() {
			// TODO Auto-generated method stub
			
		}

		public List<UserMapping> getusermap(String user){
			List<UserMapping> usrmaplist= new ArrayList<>();
		
			try{
			DBConnection dbc = new DBConnection();
			Connection connection = dbc.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT common_user_mapping.`user_id`, `app_username` FROM common_user_mapping left join common_login_user_master on common_login_user_master.user_id=common_user_mapping.user_id where login_username=?");	// where active_status="+0);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				UserMapping usr=new UserMapping();
				usr.setUser_id(rs.getInt(1));
				usr.setApp_username(rs.getString(2));
				usrmaplist.add(usr);
			}
			/*while (rs.next()) {
				Application apps= new Application();
				apps.setApp_Id(rs.getInt(1));
				apps.setApp_Name(rs.getString(2));
				appsList.add(apps);
				System.out.println(rs.getString(2));
			}*/
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return usrmaplist;
		} 	
		
		
	
	 /* public List<LoginUser> getValidate(){
	        Session session = SessionUtil.getSession();    
	        Query query = session.createQuery("from common_login_user_master");
	        List<LoginUser> cmpapps =  query.list();
	        session.close();
	        return cmpapps;
	    }*/

}
