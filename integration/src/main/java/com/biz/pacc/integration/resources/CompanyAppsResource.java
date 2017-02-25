package com.biz.pacc.integration.resources;
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.biz.pacc.integration.model.CompanyApps;
import com.biz.pacc.integration.model.Employee;
import com.biz.pacc.integration.dao.CompanyAppsDAO;
import com.biz.pacc.integration.dao.EmployeeDAO;
 
 
@Path("/cmpapps")
public class CompanyAppsResource {
	
    @GET
    @Produces("application/json")
    public List<CompanyApps> getEmployee() {
        CompanyAppsDAO dao = new CompanyAppsDAO();
        List<CompanyApps> capps = dao.getAllCmpApps();
        return capps;
    }
    
    @GET
    @Produces("application/json")
    @Path("apps")
    public List<CompanyApps> getAllApps() {
        CompanyAppsDAO dao = new CompanyAppsDAO();
        List<CompanyApps> capps = dao.getAllCmpApps();
        return capps;
    }
    
    @POST
    @Path("/create")
    //@Consumes("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public Response addCompanyApp(@FormParam("app_url") String appUrl, @FormParam("db_name") String dbName,
    		@FormParam("biz_admin_id") int bizAdminId, @FormParam("mandate_mac") int mandate_mac ,
    		@FormParam("mandate_ip") int mandate_ip, @FormParam("under_main") String under_main){
    	CompanyApps capps = new CompanyApps();
    	capps.setApp_id(1);
//    	capps.setComp_id(1);
    	capps.setApp_url(appUrl);
    	capps.setDb_name(dbName);
    	capps.setBiz_admin_user_id(bizAdminId);
    	capps.setMac_req(mandate_mac);
    	capps.setIp_req(mandate_ip);
    	capps.setUnder_maint(under_main);
    	
    	CompanyAppsDAO dao = new CompanyAppsDAO();
        dao.addCompanyApps(capps);
        String output = "Company Apps Created Successfully";
//                "Company Apps Created Successfully - <a href=Company Master.html>Click Here</a> <br> to create new Company Master</font>";
        
        return Response.ok(output).build();	//Response.status(200).entity(output).build();	//Response.ok(output).build();
    }
    
    
    /* public Response addCompanyApp(String dbName){
    	CompanyApps capps = new CompanyApps();
    	/*capps.setApp_url(appUrl);
    	capps.setDb_name(dbName);
         System.out.println(dbName);       
//    	CompanyAppsDAO dao = new CompanyAppsDAO();
//        dao.addEmployee(capps);
        String output = "<font face='verdana' size='2'>" +
                "Company Apps Created Successfully - <a href=Company Master.html>Click Here</a> <br> to create new Company Master</font>";
        
        return Response.ok(output).build();	//Response.status(200).entity(output).build();	//Response.ok(output).build();
    }*/
    
   
    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
 