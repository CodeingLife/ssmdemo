package com.ssmdemo.resolver.exception;
/**
 * 
 * @Title:CustomException.java
 * @Package:com.ssmdemo.resolver.exception
 * @Description:TODO(自定义异常处理类)
 * @author:Kylin
 * @date:2018年9月28日上午10:10:20
 * @version:V1.0
 */

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6999833679267248281L;
	
	
	private String message;
	private Exception e;
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public CustomException(Exception e) {
		this.e = e;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}
	
	
	
}
