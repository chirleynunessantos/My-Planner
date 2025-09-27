package br.com.myplanney.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myplanney.tarefas.model.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}
