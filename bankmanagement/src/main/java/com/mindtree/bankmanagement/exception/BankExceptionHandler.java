package com.mindtree.bankmanagement.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BankExceptionHandler {



		@ExceptionHandler
		public ModelAndView exceptionHandler(HttpServletRequest req, ServiceException e)
		{
			ModelAndView mv=new ModelAndView();
			mv.addObject("status",HttpStatus.NOT_FOUND.value());
			mv.addObject("ErrorMessage",e.getMessage());
			mv.addObject("TimeStamp",new Date());
			mv.setViewName("error");
			return mv;
		}
		
	}

