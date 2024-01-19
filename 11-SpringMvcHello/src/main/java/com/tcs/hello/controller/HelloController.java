package com.tcs.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {


	/*
	 * sayHello(): is the request handler method of (/hello request)
	 *
	 *Parameters:viewName name of the View to render, to be resolved by the
	 * DispatcherServlet's ViewResolvermodelName name of the single entry in the 
	 * modelmodelObject the single model object
	 *
	 * show: is the view file name
	 * 
	 * message
	 */
	@GetMapping(value="/hello")
	public ModelAndView sayHello()
	{
		ModelAndView mv=new ModelAndView("show","message","Welcome to MVC!!!");
		return mv;
	}
}
