package br.com.lvdc.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class LocadoraBusinessException extends RuntimeException{


	public LocadoraBusinessException(String message) {
		super(message);
    }

	
}
