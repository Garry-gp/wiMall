package com.example.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




@ControllerAdvice
@ResponseBody
public class ExceptionAction{
	private static final Logger LOGGER = Logger.getLogger(ExceptionAction.class);
	
	@ExceptionHandler(value=ApplicationException.class)
	public Map<String, Object> applicationException(ApplicationException exception){
		LOGGER.info(HttpStatus.NOT_FOUND + ">>>>>>>>>>>" +exception.getMessage());
		Map<String,Object> eMap = new HashMap<>();
		eMap.put("massege", exception.getMessage());
		eMap.put("erroy type", exception.getClass());
		eMap.put("code", HttpStatus.NOT_FOUND);
		return eMap;	
	}

}
