package com.biz.pacc.integration.dao;
import java.util.List;

import com.biz.pacc.integration.model.CompanyApps;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class CompanyAppsDAO {
    
    public void addCompanyApps(CompanyApps bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addEmployee(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addEmployee(Session session, CompanyApps capps){
    	//TODO add loggers
    	CompanyApps cmpApp= new CompanyApps();
    	cmpApp.setApp_id(capps.getApp_id());
    	cmpApp.setApp_url(capps.getApp_url());
    	cmpApp.setDb_name(capps.getDb_name());
    	capps.setBiz_admin_user_id(capps.getBiz_admin_user_id());
    	capps.setMac_req(capps.getMac_req());
    	capps.setIp_req(capps.getIp_req());
    	capps.setUnder_maint(capps.getUnder_maint());
        
        session.save(cmpApp);
    }
    
    public List<CompanyApps> getAllCmpApps(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Employee");
        List<CompanyApps> cmpapps =  query.list();
        session.close();
        return cmpapps;
    }
 /*
    public int deleteEmployee(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Employee where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }*/
    
    /*public int updateEmployee(int id, Employee emp){
         if(id <=0)  
               return 0;  
         	Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Employee set name = :name, age=:age where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("name",emp.getName());
            query.setInteger("age",emp.getAge());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }*/
}
 
 
