package br.com.myplanney.core.tarefas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.core.tarefas.model.Tarefas;
import br.com.myplanney.core.tarefas.repository.TarefasRepository;
import br.com.myplanney.core.tarefas.service.TarefasServices;
import br.com.myplanney.core.usuario.model.Usuario;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

	@Autowired
	TarefasRepository repository;
	@Autowired
	TarefasServices service;
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Tarefas tarefas) {
		
		
		service.salvar(tarefas);
	return ResponseEntity.ok(tarefas);
	}
	
	@PutMapping
	public ResponseEntity alterar(@RequestBody Tarefas tarefas) {
		
	//Optional<Tarefas> usuario = repository.findById(tarefas.getId());
	
	//Tarefas tarefaAlterada = new Tarefas(tarefas.getId(),tarefas.getPrioridades(),tarefas.getCartegoria(),tarefas.getNome());
		
	//repository.save(tarefaAlterada);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity delete(Long id) {
		repository.deleteById(id);
	return ResponseEntity.ok().build();
	}
	
	
}
