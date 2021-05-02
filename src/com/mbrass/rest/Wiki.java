package com.mbrass.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

@Path("/wiki")
public class Wiki {
	
	static String path = "E:\\tmp\\details.txt";
	
	  @GET  
	  @Produces(MediaType.TEXT_HTML)  
	  public String sayHtmlWorld() throws FileNotFoundException, ParseException {  
		  
		  StringBuffer sb = new StringBuffer();
	    sb.append( "<html> " + "<title>" + "Wiki"  + "</title>"  
	        + "<head>\r\n"
	        + "<style>\r\n"
	        + ".myDiv {\r\n"
	        + "  border: 5px outset red;\r\n"
	        + "  background-color: lightblue;    \r\n"
	        + "  text-align: center;\r\n"
	        + "  display:none;"
	        + "}\r\n"
	        + "h3{"
	        + "  text-align: center;"
	        + "}\n"
	        + "h1{"
	        + "  text-align: center;"
	        + "}"
	        + "</style>\r\n"
	        + "<script>\r\n"
	        + "function myFunction(y) {\r\n"
	        + "  var x = document.getElementById(y);\r\n"
	        + "  if (x.style.display === \"none\") {\r\n"
	        + "    x.style.display = \"block\";\r\n"
	        + "  } else {\r\n"
	        + "    x.style.display = \"none\";\r\n"
	        + "  }\r\n"
	        + "}\r\n"
	        + "</script>\r\n"
	        + "</head>\r\n"
	        + "<body><h1>IMPORTANT DETAILS</h1>");
	    
	    JSONParser parser = new JSONParser(new FileInputStream(new File(path)));
	    ArrayList al=parser.list();
	    Iterator it=al.iterator();
	    
	    HashMap h1;
	    Entry t1;
	    String s1;
	   
	    Object o1;
	    
	    while(it.hasNext()) {
	    	h1=(HashMap)(it.next());
	    	sb.append("<hr>");
	    	sb.append("<h3 onclick=\"myFunction('A"+h1.get("key")+"')\">"+h1.get("key")+"</h3>\r\n"
					+ "<div class=\"myDiv\" id=\"A"+h1.get("key")+"\">\r\n"
					+ "  <h2>"+h1.get("key")+"</h2>\r\n"
					+ "  <p>"+h1.get("value")+"</p>\r\n"
					+ "</div>\r\n"
					+ "</div>");
	    }
	    
	    
	    sb.append("</body></html> ");
	    return sb.toString();
	  } 
	
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createEntry(Entry entry) throws Exception {
	    JSONParser parser = new JSONParser(new FileInputStream(new File(path)));
	    ArrayList al=parser.list();

	    System.out.println("-----------------------");
	    System.out.println(al);
	    
	    Vector<Entry> v1= new Vector();
	    
	    Iterator it=al.iterator();
	    Entry tmp;	
	    HashMap tmp1;
	    
	    while(it.hasNext()) {
	    	tmp1=(HashMap)it.next();
	    	v1.add(new Entry((String)tmp1.get("key"),(String)tmp1.get("value")));
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    
	    sb.append("[");
	    for(int i=0;i<v1.size();i++) {
	    	sb.append(v1.get(i).toStr()+",");
	    }
	    sb.append(entry.toStr());
	    sb.append("]");
	    FileWriter fw = new FileWriter(path);
	    fw.write(sb.toString());
	    fw.close();
	    return "Object Added "+entry.toStr();
    }

}
