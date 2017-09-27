package com.xlbean.xlgenapp.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class BaseExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, IllegalArgumentException.class, })
	@ResponseBody
	public Map<String, Object> handleValidationError(Exception e) {
		e.printStackTrace();
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("message", "Invalid Request");
		return errorMap;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public Map<String, Object> handleError(Exception e) {
		e.printStackTrace();
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("message", "Server Error");
		return errorMap;
	}

}