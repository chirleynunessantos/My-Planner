package br.com.myplanney.core.habitos.model;

import br.com.myplanney.core.tarefas.model.Tarefas;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
/*
@Entity
@Table(name="habitos")
@Data
@Builder*/
public class Habitos {

	String nome;
	int quantDiasCheck;
}
