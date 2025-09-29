package br.com.myplanney.core.tarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.myplanney.core.tarefas.model.Tarefas;
import br.com.myplanney.core.tarefas.repository.TarefasRepository;
import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;

@Service
public class TarefasServices {

	@Autowired
	TarefasRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void salvar( Tarefas tarefas) {
		String email =  (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
	//	UserDetails usuario = usuarioRepository.findByEmail(email);
	//	tarefas.setId(usuario.get);
		
		repository.save(tarefas);

	}
	public void save(Tarefas tarefas) {
		
		
	}
}
