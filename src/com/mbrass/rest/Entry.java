package com.mbrass.rest;

public class Entry {

	String key;
	String value;
	
	public Entry() {
		
	}
	
	public Entry(String key, String value) {
		this.key=key;
		this.value=value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toStr() {
		return "{\"key\":\""+key+"\",\"value\":"+"\""+value+"\"}";
	}
	
	public String toJsStr() {
		String sb = "<h3 onclick=\"myFunction('A"+key+"')\">Server 1</h3>\r\n"
				+ "<div class=\"myDiv\" id=\"A"+key+"\">\r\n"
				+ "  <h2>"+key+"</h2>\r\n"
				+ "  <p>"+value+"</p>\r\n"
				+ "</div>\r\n"
				+ "</div>";
		return sb;
	}
}
