package com.example.ctrl.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Administrator
 * @date 2018年3月13日
 * @Description:前端接口响应json包装体
 */
@JsonInclude(value = Include.NON_NULL) // 空字段不参数json转换
public class WResponse<T> {

	private String message;

	private T data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
