package br.com.myplanney.tarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.myplanney.tarefas.model.Tarefas;
import br.com.myplanney.tarefas.repository.TarefasRepository;
import br.com.myplanney.usuario.model.Usuario;
import br.com.myplanney.usuario.repository.UsuarioRepository;

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
