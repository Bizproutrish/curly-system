package com.biz.pacc.integration.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetLocalTime {

	public String getTimeStamp(){
	    	Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");//("HH:mm:ss");
	        System.out.println( sdf.format(cal.getTime()) );
	        return sdf.format(cal.getTime());
	        /*
	    	String formattedTime="";
	    	try {
	    		Calendar cal = Calendar.getInstance();
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		Date d;
			
				d = sdf.parse(cal.getTime().toString());
				formattedTime = output.format(d);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println(formattedTime);
	    	return formattedTime;
	        
	         */	        
	    }

	        

    public static void main(String[] args) {
    	
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	try{
    		/*System.out.println(cal.getTime());
    		System.out.println(sdf.format(cal.getTime()));
    		*/
    		String d = sdf.format(cal.getTime().toString());	//parse(cal.getTime().toString());
    		
    		String formattedTime = output.format(d);
    		//System.out.println(cal.getTime());
    		System.out.println(formattedTime);
    	
    	}catch(Exception e){
    		
    	}
    	
    	
    	/* 	
    	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");//("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(time);
        String formattedTime = output.format(d);*/
    }
    
}

