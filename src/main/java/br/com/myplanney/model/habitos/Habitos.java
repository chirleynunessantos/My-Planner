package br.com.myplanney.model.habitos;

import br.com.myplanney.model.tarefas.Tarefas;
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
