package com.mindtree.travelbooking.exception.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.mindtree.travelbooking.dto.ResponseDto;

@ControllerAdvice
public class TravelExceptionHandler {
	
	public ResponseDto<Object> ServiceExceptionHandler(Exception e) {

		return new ResponseDto<Object>(null,e.getMessage(),"exception occured",false);
		
	}

}
