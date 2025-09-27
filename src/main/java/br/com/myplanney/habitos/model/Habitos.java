package br.com.myplanney.habitos.model;

import br.com.myplanney.tarefas.model.Tarefas;
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
