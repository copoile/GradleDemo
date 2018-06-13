package com.example.common.excption;

public class MyRunTimeExcption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1653664651645354714L;

	/**
	 * 定义异常信息
	 */
	private String message;

	public MyRunTimeExcption() {
		super();
	}

	public MyRunTimeExcption(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
