package br.com.myplanney.core.usuario.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import br.com.myplanney.exceptions.UsuarioJaCadastradoException;


@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;	
	private final PasswordEncoder  passwordEncoder;
	
	public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	public Usuario salvarUsuario(Usuario usuario) {			
		
		if (this.repository.findByEmail(usuario.getUsername()).isPresent()) {
			 throw  new UsuarioJaCadastradoException("Email já cadastrado");
		}

		String senhaCodificada = passwordEncoder.encode(usuario.getPassword());

		Usuario usuarioAlterado = new Usuario(usuario.getEmail(), usuario.getNome(), senhaCodificada, usuario.getRole());
		
		return repository.save(usuario);
	}
}
