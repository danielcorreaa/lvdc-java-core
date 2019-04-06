package br.com.lvdc.core.exception;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorDetails {
	
	@NonNull
	private Date timestamp;
	@NonNull
	private String message;
	@NonNull
	private String details;

}
