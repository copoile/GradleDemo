package com.example.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.common.excption.MyRunTimeExcption;
import com.example.common.excption.SystemLogger;
import com.example.ctrl.model.WResponse;

@ControllerAdvice(annotations = RestController.class)
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<WResponse<?>> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WResponse<?> beforeBodyWrite(WResponse<?> body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 切面异常处理
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public Object handleException(Throwable exception) throws Exception {
		WResponse<?> res = new WResponse<>();
		if (exception instanceof MyRunTimeExcption) {
			MyRunTimeExcption e = (MyRunTimeExcption) exception;
			res.setMessage(e.getMessage());
			SystemLogger.info(exception);
		} else if (exception instanceof MissingServletRequestParameterException) {
			// 400 bad request
			MissingServletRequestParameterException e = (MissingServletRequestParameterException) exception;
			res.setMessage(e.getMessage());
			SystemLogger.info(exception);
		} else {
			res.setMessage("系统错误");
			SystemLogger.info(exception);
		}
		return res;
	}

}
