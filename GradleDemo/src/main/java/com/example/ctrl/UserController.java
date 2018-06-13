package com.example.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/user")
public class UserController {

	private static final Logger log=Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request,HttpServletResponse response){
		log.info("---初始化登陆页面---");
		return "login";
	}
	@RequestMapping(value="/test")
	public String test(HttpServletRequest request,HttpServletResponse response){
		log.info("---初始化分页测试页面---");
		return "test";
	}
}
