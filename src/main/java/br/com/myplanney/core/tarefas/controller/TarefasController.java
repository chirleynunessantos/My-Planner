package br.com.myplanney.core.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.core.tarefas.service.TarefasServices;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import br.com.myplanney.dto.request.TarefasRequestDTO;
import br.com.myplanney.mapper.TarefaMapper;

@RestController
@RequestMapping("tarefas")
public class TarefasController {

	@Autowired
	TarefasServices service;

	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TarefaMapper mapper;
	
	@PostMapping
	public ResponseEntity salvar(  @RequestBody TarefasRequestDTO tarefas) {
		
		service.salvar(mapper.paraTarefa(tarefas));

		return ResponseEntity.ok(tarefas);
	}

}
