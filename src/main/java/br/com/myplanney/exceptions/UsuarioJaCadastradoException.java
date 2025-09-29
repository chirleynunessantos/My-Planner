package br.com.myplanney.exceptions;

public class UsuarioJaCadastradoException extends RuntimeException  {

	public UsuarioJaCadastradoException(String mensagem){
		super(mensagem);
	}
}
