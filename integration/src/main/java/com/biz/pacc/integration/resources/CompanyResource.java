package com.biz.pacc.integration.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.biz.pacc.integration.model.Application;
import com.biz.pacc.integration.model.CompanyMaster;
import com.biz.pacc.integration.model.DB_Names;
import com.biz.pacc.integration.services.CompanyService;

@Path("company")
public class CompanyResource {
	
	CompanyService cmpService = new CompanyService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CompanyMaster> getAllCompanies(){
		return cmpService.getAllCompanies();	//"Hello .. Wel come to My Company";
	}
	
	@GET
	@Path("databases")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DB_Names> getAllDatabases(){
		return cmpService.getAllDatabases();	//"Hello .. Wel come to My Company";
	}
	
	@GET
	@Path("apps")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Application> getAllApps(){
		return cmpService.getAllApps();	//"Hello .. Wel come to My Company";
	}
	
	@GET
	@Path("{cmpid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CompanyMaster getCompanyName(@PathParam("cmpid") int cid){
		return cmpService.getCmpName(cid);				//"Hello .. Wel come to My Company";
	}
	
	
	
	@POST
	@Path("addcmp")
//	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public CompanyMaster addCompany(@FormParam("cmp_id") String ccode,
									@FormParam("cmp_name") String cname,
									@FormParam("cmp_login")int logicId) {
		//CompanyMaster cmp = new CompanyMaster(ccode,cname,logicId,"dbname",1);	
		System.out.println(cname);
		return cmpService.addCompany(ccode,cname,logicId,cname);				//"Hello .. Wel come to My Company";
		
		
		
	}

}
