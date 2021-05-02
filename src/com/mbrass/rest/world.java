package com.mbrass.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/world")
public class world {
	    
	  // This method is called if HTML and XML is not requested  
	  @GET  
	  @Produces(MediaType.TEXT_PLAIN)  
	  public String sayPlainTextWorld() {  
	    return "Hello World ::  ORDER"+getOrders();  
	  }  
	  
	  // This method is called if XML is requested  
	  @GET  
	  @Produces(MediaType.TEXT_XML)  
	  public String sayXMLWorld() {  
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello World ::  ORDER"+getOrders() + "</hello>";  
	  }  
	  
	  // This method is called if HTML is requested  
	  @GET  
	  @Produces(MediaType.TEXT_HTML)  
	  public String sayHtmlWorld() {  
	    return "<html> " + "<title>" + "Hello World"  + "</title>"  
	        + "<body><h1>" + "Hello Jersey HTML world  ::  ORDER "+getOrders() + "</h1></body>" + "</html> ";  
	  } 
	
	  
	   static Map<Integer, Order> orders = new HashMap<Integer, Order>();
	  
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public void createOrder(Order order) {
	        orders.put(order.id, order);
	    }
	    
	    public String getOrders() {
	    	String str="";
	    	for(int i=0;i<orders.size();i++) {
	    		str=str+"::"+i;
	    	}
	    	return str;
	    }
	  
	}   

