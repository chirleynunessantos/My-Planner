package br.com.myplanney.infra.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.myplanney.exceptions.UsuarioJaCadastradoException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UsuarioJaCadastradoException.class)
	private ResponseEntity<RestErrorMessage> usuarioJaCadastrado(UsuarioJaCadastradoException exception){	
		
		RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
	}
	
}
