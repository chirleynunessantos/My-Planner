package br.com.myplanney.core.tarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.myplanney.core.enuns.Prioridade;
import br.com.myplanney.core.tarefas.model.Tarefas;
import br.com.myplanney.core.tarefas.repository.TarefasRepository;
import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

@Service
public class TarefasServices {

	@Autowired
	TarefasRepository repository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void salvar( Tarefas tarefas) {
	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String email = authentication.getName();
	    
	    Usuario usuario = (Usuario) usuarioRepository.findByEmail(email).orElseThrow();
	    Long id;
		
	    Tarefas tarefasCompleta = new Tarefas(
	    		tarefas.getPrioridade(),
	    		tarefas.getCategoria(),
	    		tarefas.getNome(),
	    		usuario
	    		);
	    
		repository.save(tarefasCompleta);

	}

}
