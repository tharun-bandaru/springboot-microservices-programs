package com.tcs.register.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimerInterceptor implements HandlerInterceptor {

	public long startTime,endTime,diff;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTime=System.currentTimeMillis();
		System.out.println("pre handle method");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post handle");
		endTime=System.currentTimeMillis();
		diff=startTime-endTime;
		request.setAttribute("diff", diff);
	}
}
