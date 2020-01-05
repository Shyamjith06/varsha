package com.mindtree.travelbooking.dto;

public class ResponseDto<T> {
	
	private T data;
//	private ErrorDto error;
	private String message;
	private String header;
	//private HttpStatus httpStatus;

	private boolean success;
	
	
	
	public ResponseDto() {
		super();
	}
	
	
public ResponseDto(T data, String message, String header, boolean success) {
		super();
		this.data = data;
		this.message = message;
		this.header = header;
		this.success = success;
	}


//public ResponseDto(T data, String message, String header, HttpStatus httpStatus, boolean success) {
//		super();
//		this.data = data;
//		this.message = message;
//		this.header = header;
//		//this.httpStatus = httpStatus;
//		this.success = success;
//	}





	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
