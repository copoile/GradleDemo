package com.example.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ctrl.model.WResponse;
import com.example.mapper.dao.UserDo;
import com.example.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserApiController extends BaseController {

	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	/**
	 * 用户登录,请求参数较少时可以使用@RequestParam接收参数 参数较多时可以使用类接收参数
	 * 
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public WResponse<?> login(HttpServletRequest request,
			@RequestParam(value = "loginname", required = false) String loginname,
			@RequestParam(value = "password", required = false) String password) {
		log.info("--用户登录--");
		UserDo userDo = userService.login(loginname, password);
		userSaveToSession(userDo, request);
		return getResponse();

	}

	/**
	 * 将登录的用户信息存放到会话中
	 * 
	 * @param userDo
	 * @param request
	 */
	private void userSaveToSession(UserDo userDo, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("user", userDo);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public WResponse<?> register(HttpServletRequest request, UserDo userDo) {
		userService.register(userDo);
		log.info("--用户注册--");
		return getResponse();

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public WResponse<?> updateUser(HttpServletRequest request, UserDo userDo, HttpSession session) {
		userService.updateUser(userDo);
		log.info("--更改用户信息--");
		userSaveToSession(userDo, request);
		return getResponse();
	}
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public WResponse<?> forgetPassword(HttpServletRequest request, UserDo userDo, HttpSession session) {
		userService.updateUser(userDo);
		log.info("--找回密码--");
		userSaveToSession(userDo, request);
		return getResponse();
	}
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	public @ResponseBody WResponse<UserDo> querybyid(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "id", required = true) Long id) {
		log.info("-查询单个用户信息--");
		UserDo userDo = userService.findById(id);
		return getResponse(userDo);
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public @ResponseBody WResponse<?> delbyid(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "id", required = true) Integer id) {
		log.info("--删除单个用户信息--");
		return getResponse();
	}

}
