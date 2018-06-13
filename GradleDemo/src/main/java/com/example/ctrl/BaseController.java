package com.example.ctrl;

import org.springframework.web.bind.annotation.RestController;

import com.example.ctrl.model.WResponse;



/**
 * @author Administrator
 * @date 2018年3月13日
 * @Description:api接口基础控制
 */
@RestController
public class BaseController {


	
	/**
	 * 初始化响应体,默认成功
	 * @return
	 */
	private <T> WResponse<T> init() {
		WResponse<T> res = new WResponse<>();
		res.setMessage("success");
		return (WResponse<T>) res;
	}

	/**
	 * 获取带数据体response
	 * 
	 * @param data
	 * @return
	 */
	protected <T> WResponse<T> getResponse(T data) {
		WResponse<T> res = init();
		res.setData(data);
		return res;
	}

	/**
	 * 获取无数据体response
	 * 
	 * @return
	 */
	protected <T> WResponse<T> getResponse() {
		return getResponse(null);
	}

}
