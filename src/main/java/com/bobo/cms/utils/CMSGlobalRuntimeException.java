package com.bobo.cms.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yangchunbo.common.utils.CMSRuntimeException;

@Component
public class CMSGlobalRuntimeException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		if(!(ex instanceof CMSRuntimeException)) {
		
		   mv.addObject("message", "系统出现未知异常");
		   mv.setViewName("common/error");
		}
		HandlerMethod d = 	(HandlerMethod)handler;
	
		System.out.println(	d.getMethod());
		return mv;
	}

}
