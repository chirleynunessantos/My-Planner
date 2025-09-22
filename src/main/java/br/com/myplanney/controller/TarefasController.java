package br.com.myplanney.controller;

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

import br.com.myplanney.model.Usuario;
import br.com.myplanney.model.tarefas.Tarefas;
import br.com.myplanney.repository.TarefasRepository;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

	@Autowired
	TarefasRepository repository;
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Tarefas tarefas) {
		repository.save(tarefas);
	return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity alterar(@RequestBody Tarefas tarefas) {
		
	Optional<Tarefas> usuario = repository.findById(tarefas.getId());
	
	Tarefas tarefaAlterada = new Tarefas(tarefas.getId(),tarefas.getPrioridades(),tarefas.getCartegoria(),tarefas.getNome());
		
	repository.save(tarefaAlterada);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity delete(Long id) {
		repository.deleteById(id);
	return ResponseEntity.ok().build();
	}
	
	
}
