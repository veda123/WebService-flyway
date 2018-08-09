package com.testSetTool.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MediaTypeNotSupportedStatusException;
import org.springframework.web.server.MethodNotAllowedException;

import com.testSetTool.entities.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController {

	   @ExceptionHandler (ResourceNotFoundException.class)
	    @ResponseStatus(value= HttpStatus.NOT_FOUND)
	    public ResponseEntity<ErrorResponse> requestHandlingNoHandlerFound(Exception e) {
		   ErrorResponse errorResp = new ErrorResponse();
		   errorResp.setCode(HttpStatus.NOT_FOUND.value());
		   errorResp.setMessage(e.getMessage());
		   return new ResponseEntity<ErrorResponse>(errorResp,HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler (MethodNotAllowedException.class)
	   @ResponseStatus(value= HttpStatus.METHOD_NOT_ALLOWED)
	    public ResponseEntity<ErrorResponse> handleError(Exception e) {
		   ErrorResponse errorResp = new ErrorResponse();
		   errorResp.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		   errorResp.setMessage(e.getMessage());
		   return new ResponseEntity<ErrorResponse>(errorResp,HttpStatus.METHOD_NOT_ALLOWED);
	   }
	   
	   @ExceptionHandler (MediaTypeNotSupportedStatusException.class)
	   @ResponseStatus(value= HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	    public ResponseEntity<ErrorResponse> handleUnsupportedMedia(Exception e) {
		   ErrorResponse errorResp = new ErrorResponse();
		   errorResp.setCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
		   errorResp.setMessage(e.getMessage());
		   return new ResponseEntity<ErrorResponse>(errorResp,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	   }
	   
	   @ExceptionHandler (Exception.class)
	    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity<ErrorResponse> handle(Exception e) {
		   ErrorResponse errorResp = new ErrorResponse();
		   errorResp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		   errorResp.setMessage(e.getMessage());
		   return new ResponseEntity<ErrorResponse>(errorResp,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
}
