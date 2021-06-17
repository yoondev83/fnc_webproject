package com.webprj.project_green.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	public List loginEssential = Arrays.asList("/board/new", "/board/list/like/**");

	public List loginInessential = Arrays.asList();
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(!request.getMethod().equalsIgnoreCase("POST")) {
			String loginId = (String)request.getSession().getAttribute("id");
	
	        if(loginId != null){
	        	System.out.println("로그인 되어 있음");
	        	return true;
	        }
	        
	        else{
	        	System.out.println("로그인 안되어 있음");
	            String destUri = request.getRequestURI();
	            String destQuery = request.getQueryString();
	            String dest = (destQuery == null) ? destUri : destUri+"?"+destQuery;
	            request.getSession().setAttribute("redirect", dest);
	            System.out.println(destUri + destQuery + dest);
	        
	            response.sendRedirect("/login");
	            return false;
	        }
		}
		return true;
	}
	
}
