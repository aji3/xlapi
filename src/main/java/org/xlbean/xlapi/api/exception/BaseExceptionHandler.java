package org.xlbean.xlapi.api.exception;

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
	
	public enum ErrorCause {UNKNOWN, FORMAT_EXCEPTION};

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, IllegalArgumentException.class, })
	@ResponseBody
	public Map<String, Object> handleValidationError(Exception e) {
		ErrorMessageBuilder builder = new ErrorMessageBuilder();
		builder.message("Invalid Request");
		if (e instanceof MethodArgumentTypeMismatchException) {
			MethodArgumentTypeMismatchException exp = (MethodArgumentTypeMismatchException) e;
			String field = exp.getName();
			ErrorCause cause = ErrorCause.UNKNOWN;
			String detail = exp.getMessage();
			if (exp.getCause() instanceof NumberFormatException) {
				cause = ErrorCause.FORMAT_EXCEPTION;
			}
			builder.error(field, cause, detail);
		} else {
			e.printStackTrace();
		}
		return builder.build();
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