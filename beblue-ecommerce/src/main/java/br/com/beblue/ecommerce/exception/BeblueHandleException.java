package br.com.beblue.ecommerce.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class BeblueHandleException {

	@ExceptionHandler({ BeblueErroException.class })
	public ResponseEntity<String> handleBusinessException(HttpServletRequest req, HttpServletResponse response, BeblueErroException e) {
		return new ResponseEntity<String>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
