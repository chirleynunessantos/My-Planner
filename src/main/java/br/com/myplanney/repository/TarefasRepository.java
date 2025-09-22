package br.com.myplanney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myplanney.model.tarefas.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}
