package br.com.myplanney.infra.config;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorMessage {
	private HttpStatus status;
	private String message;
	
	
	
}
