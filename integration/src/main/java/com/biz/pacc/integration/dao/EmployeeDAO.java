package com.biz.pacc.integration.dao;


import java.util.List;
 
import com.biz.pacc.integration.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class EmployeeDAO {
    
    public void addEmployee(Employee bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addEmployee(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addEmployee(Session session, Employee emp){
        Employee employee = new Employee();
        
        employee.setName(emp.getName());
        employee.setAge(emp.getAge());
        
        session.save(employee);
    }
    
    public List<Employee> getEmployees(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Employee");
        List<Employee> employees =  query.list();
        session.close();
        return employees;
    }
 
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
    }
    
    public int updateEmployee(int id, Employee emp){
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
    }
}
 
 