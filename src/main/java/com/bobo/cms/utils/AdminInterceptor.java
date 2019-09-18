package com.bobo.cms.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bobo.cms.domain.User;
/**
 * 
 * @ClassName: AdminInterceptor 
 * @Description: 管理员后台拦截器
 * @author: charles
 * @date: 2019年7月19日 上午11:03:49
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//false 表示,当前的请求的有没有session,如果没有则不创建session,true:没有session则创建session,建议使用false
	
		HttpSession session = request.getSession(false);
		if(null==session || null== session.getAttribute(CMSConstant.LOGIN_ADMIN)) {
		
			request.setAttribute("msg", "请登录后再下一步操作...");
			request.setAttribute("user",new User());
		  request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);
		}
		return true;
	}
	

}
