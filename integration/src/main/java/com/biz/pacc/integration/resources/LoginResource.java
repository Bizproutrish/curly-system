package com.biz.pacc.integration.resources;

import java.net.*;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.biz.pacc.integration.dao.CompanyAppsDAO;
import com.biz.pacc.integration.dao.LoginServiceDAO;
import com.biz.pacc.integration.model.CompanyApps;
import com.biz.pacc.integration.model.CompanyMaster;
import com.biz.pacc.integration.model.LoginUser;
import com.biz.pacc.integration.model.UserMapping;

//import javax.servlet.http.HttpServletRequest;

@Path("login")
public class LoginResource {
	
	//LoginServiceDAO logService = new LoginServiceDAO();

	 @POST
	 @Produces("application/json")
	 @Path("validate")
	 public Response getLoginUser(@FormParam("username") String uname,@FormParam("password") String pwd, @Context HttpServletRequest requestContext,@Context SecurityContext context) {
		 URI uri,uri2 = null;
		 
		 String client_ip = requestContext.getRemoteAddr();

	       //If security is enabled
	       //Principal principal = context.getUserPrincipal();
	       //String userName = principal.getName();
	       //System.out.println(userName);
	       System.out.println(client_ip);
	       
	       GetIpMac getipmac=new GetIpMac();
	       String client_mac_add=getipmac.getMac(client_ip);
		 
		 //System.out.println("Ip: " + GetIpMac.GetAddress("ip"));
		 //System.out.println("Mac: " + GetIpMac.GetAddress("mac"));
		 
		 LoginServiceDAO dao = new LoginServiceDAO();
		 LoginUser capps = dao.getLogUserDetails(uname,pwd, client_ip, client_mac_add);
		 
		 //System.out.println(capps);
		//return Response.status(200).entity(uri).build();
		  try{
			  uri = new URI("http://192.168.3.99:9091/integration/landingpage.html#?username="+uname);//("http://192.168.3.136:8080/BizLMS/bizint.php?app=LMS");
			  uri2 = new URI("http://192.168.3.99:9091/integration/index.html#?Err=1");//("http://192.168.3.136:8080/BizLMS/bizint.php?app=LMS");
			  if(!capps.getPassword().equals(null)){
				return Response.temporaryRedirect(uri).build();			  
			  }
			  else
				return Response.temporaryRedirect(uri2).build();
		//return capps;
			  }catch(URISyntaxException e){
			 e.printStackTrace();
		 }catch(NullPointerException e){
			 e.printStackTrace();
		 }
		return Response.temporaryRedirect(uri2).build();
	 }  	 
	 
	 
		 
//	 common_login_user_master; 
//		LoginUser;
//		
	@POST
	@Path("check")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response validate(@FormParam("username") String uname,@FormParam("password") String pwd) {
		System.out.println(uname);
		URI uri,uri2;
		  
		   
		
		try {
			
			uri = new URI("http://localhost:9092/integration/landingpage.html");//("http://192.168.3.136:8080/BizLMS/bizint.php?app=LMS");
			uri2= new URI("/login/failure");
				
		 if(uname.equals("admin") && pwd.equals("pass"))
			  //@Path("http://localhost:8010/NewWebServiceproject/new/login/success");
			  {
			 	
			 	return Response.temporaryRedirect(uri).build();
			 	//	Response.seeOther(uri);
			            //return Response.status(200).entity("user successfully login").build();
			            /*@POST
			            public Response yourAPIMethod() {
			                URI targetURIForRedirection = ...;
			                return Response.seeOther(targetURIForRedirection).build();
			            }*/
			            }
			        else
			        {
			            return Response.temporaryRedirect(uri2).build();
			            //Response.seeOther(uri2);
			            //return Response.status(200).entity("user logon failed").build();
			            }
		 
	
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return null;
	}
	 	@POST
	    @Path("/success")
	    public Response successpage()
	    {
	    return Response.status(200).entity("user successfully login").build();
	    }
	    @POST
	    @Path("/failure")
	    public Response failurepage()
	    {
	    return Response.status(200).entity("user logon failed").build();
	    }
	    
	    @POST
	    @Consumes
	    @Path("landing")
	    public Response lmsRedirect(@PathParam("app") int appId) {
	    	URI uri,uri2;
			
			try {
				uri = new URI("http://192.168.3.136:8080/BizLMS/bizint.php?app=LMS");	//("http://localhost:9092/integration/landingpage.html");
				uri2= new URI("www.google.co.in");
					
			 if(appId==1)
				  //@Path("http://localhost:8010/NewWebServiceproject/new/login/success");
				  {
				 	System.out.println("Loginnnn");
				 	return Response.temporaryRedirect(uri).build();
				 	//	Response.seeOther(uri);
				            //return Response.status(200).entity("user successfully login").build();
				            /*@POST
				            public Response yourAPIMethod() {
				                URI targetURIForRedirection = ...;
				                return Response.seeOther(targetURIForRedirection).build();
				            }*/
				            }
				        else
				        {
				            return Response.temporaryRedirect(uri2).build();
				            //Response.seeOther(uri2);
				            //return Response.status(200).entity("user logon failed").build();
				            }
			 
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return null;
	    	
	    	
	    }
	    
/*	    @GET
	    @Produces("application/json")
		@Path("usermap/{user}")
	    public UserMapping getusermapping(@PathParam("user") String user)
	    {
	    	LoginServiceDAO userm=new LoginServiceDAO();
	    	UserMapping usrmap=userm.getUserMapDetails(user);
			return usrmap;
	    }*/
	    
	    @GET
	    @Produces("application/json")
		@Path("usermap/{user}")
	    public List<UserMapping> getusermapping(@PathParam("user") String user)
	    {
	    	LoginServiceDAO userm=new LoginServiceDAO();
	    	List<UserMapping> usrmap=userm.getusermap(user);
			return usrmap;
	    }
	    
	   /* @POST
	    @Path("getipmac")
	    @Produces("text/xml")
	    public void activate(@Context HttpServletRequest requestContext,@Context SecurityContext context){
	       String yourIP = requestContext.getRemoteAddr();

	       //If security is enabled
	       //Principal principal = context.getUserPrincipal();
	       //String userName = principal.getName();
	       //System.out.println(userName);
	       System.out.println(yourIP);
	       
	       GetIpMac getipmac=new GetIpMac();
	       System.out.println(getipmac.getMac(yourIP));
	    }*/
	    	
}
