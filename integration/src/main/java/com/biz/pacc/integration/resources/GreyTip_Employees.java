package com.biz.pacc.integration.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
//import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


import com.biz.pacc.integration.services.GetLocalTime;

@Path("greytip")
public class GreyTip_Employees {
	
//	@Path("employees")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getEmployees(){
	public static void main(String args[]){
		String timestamp;
		String clientUrl="https://ameri100.greythr.com/api/";
		String accessId = "d793aa4a-ea83-39c1-b1a1-d50665284ca5";
		String user="ApiUser";
		String apiKey="cc5832d5-640f-49e2-9fe0-eaa6ed29180e";
		String greyhrAPI,greyhrApiSal;
		
		GetLocalTime lt=new GetLocalTime();
		timestamp=lt.getTimeStamp();
		System.out.println(timestamp);
		greyhrAPI = clientUrl + "employees/page/1?accessId="+accessId+"&user="+user+"&timestamp="+timestamp+"&signature="+apiKey;
		greyhrApiSal=clientUrl + "salary/statement/Dec2016?accessId="+accessId+"&user="+user+"&timestamp="+timestamp+"&signature="+apiKey;
		//greyhrAPI = clientUrl + "admin/app-authenticate/employee/10018?accessId="+accessId+"&user="+user+"&timestamp="+timestamp+"&signature="+apiKey;
		
		//"http://localhost:9092/webapi/company/apps";	//
		
		try {

			System.out.println(greyhrAPI);
			
			Client client = Client.create();
			WebResource webResource = client.resource(greyhrAPI);	//"http://localhost:8080/RESTfulExample/rest/json/metallica/get");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		
		/*
		try {
			System.out.println(greyhrAPI);
			
			URL url = new URL(greyhrAPI);
			HttpURLConnection conn;
		
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return greyhrAPI; 
	*/	
	}

}
