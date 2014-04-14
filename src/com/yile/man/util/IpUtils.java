package com.yile.man.util;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class IpUtils {

	public static final Logger log = Logger.getLogger(IpUtils.class); 
	
	public static String getClientIp(HttpServletRequest request){

		   String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	}
}
