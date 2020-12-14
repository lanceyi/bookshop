package com.lance.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 管理员登录拦截器
 * @author lance
 */
public class AdminLoginIntercetor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//判断session中是否保存有已登录用户的信息
		HttpSession session = request.getSession();
		if(session.getAttribute("loginAdmin")!=null){
			//session中保存有登录用户的信息，则返回true，正常访问用户需要访问的资源
			return true;
		}
		
		//如果未登录，则跳转到登录页面
		request.setAttribute("msg","您没有权限请先登陆");
		request.getRequestDispatcher("/index.html").forward(request,response);
		return false;
	}
	
}
