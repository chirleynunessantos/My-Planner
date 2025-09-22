package br.com.myplanney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myplanney.model.tarefas.Tarefas;
import br.com.myplanney.repository.TarefasRepository;

@Service
public class TarefasServices {

	@Autowired
	TarefasRepository repository;
	public void salvar( Tarefas tarefas) {
		repository.save(tarefas);

	}
}
