package br.com.myplanney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myplanney.model.Usuario;
import br.com.myplanney.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repository;
	
	public void salvarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
}
