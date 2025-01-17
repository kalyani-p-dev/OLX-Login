package com.olx.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidLoginException extends RuntimeException{
	String message = "";
	
	public InvalidLoginException() {}
	
	public InvalidLoginException(String message) {
		this.message=message;
		
	}
	public String toString() {
		return "Incorrect stock Id "  + message;
	}

}
