package com.example.ctrl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {

	private static final Logger log = LoggerFactory.getLogger(ErrorController.class);


	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		log.info("＝＝＝进入登录失效页面＝＝＝");
		return "error/errorLogin";
	}

}
