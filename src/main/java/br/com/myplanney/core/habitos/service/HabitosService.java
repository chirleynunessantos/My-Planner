package br.com.myplanney.core.habitos.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.myplanney.core.habitos.model.Habitos;
import br.com.myplanney.core.habitos.repository.HabitoRepository;
import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitosService {

	private final HabitoRepository repository;
	private final UsuarioRepository usuarioRepository;
	
	public Habitos salvar(Habitos habitos) {
	
		var usuarioAuth = SecurityContextHolder.getContext().getAuthentication();
		String email = usuarioAuth.getName();
		Usuario usuarioBD = (Usuario) usuarioRepository.findByEmail(email).orElseThrow();
		
		return repository.save(null);
	}
}
