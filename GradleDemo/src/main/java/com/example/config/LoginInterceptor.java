package com.example.config;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author zhangbo
 * 自定义登陆拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session==null||session.getAttribute("user")==null){
			response.sendRedirect(getRedirectUrl(request));
			return false;
		}
		return true;
	}
	
	/**
	 * 获取重定向url
	 * @return
	 */
	private String getRedirectUrl(HttpServletRequest request){
		boolean b = Pattern.matches(".*/menu/index.*", request.getRequestURL());
		StringBuilder redirectUlr = new StringBuilder();
		if(b){
			redirectUlr.append(request.getContextPath());
			redirectUlr.append("/user/login");
		}else {
			redirectUlr.append(request.getContextPath());
			redirectUlr.append("/error/init");
		}
		return redirectUlr.toString();
	}

}
