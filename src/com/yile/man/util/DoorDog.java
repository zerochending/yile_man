package com.yile.man.util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yile.man.base.Constant;
import com.yile.man.index.vo.User;


public class DoorDog implements Filter {

	    public static final Logger log = Logger.getLogger(DoorDog.class); 
	    
	    public static String[] ignoreUrls = {"/ylm/login/login.ftl","/ylm/index/login.htm"};

		public void init(FilterConfig filterConfig) throws ServletException {}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		    HttpServletRequest req = (HttpServletRequest) request;

		    HttpServletResponse res = (HttpServletResponse) response;

		    HttpSession session = req.getSession(true);
		    
		    String requestUrl = req.getContextPath()+req.getServletPath();

			for (int i = 0; i < ignoreUrls.length; i++) {
				 String ignorUrl = ignoreUrls[i];
				 if(ignorUrl.equals(requestUrl)) {
					 chain.doFilter(req, res);
					 return;
				 }
				 
			}

		    User loginUser = (User) session.getAttribute(Constant.LOGIN);
		    if (loginUser==null) {//调回首页
		       String indexUrl = "http://"+req.getHeader("Host")+"/ylm";
		       res.sendRedirect(indexUrl);
		       res.setStatus(302);
		    }
		    else {
		      chain.doFilter(request,response);
		    }

		}

		public void destroy() {}
		
}
