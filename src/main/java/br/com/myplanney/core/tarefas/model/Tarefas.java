package br.com.myplanney.core.tarefas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="tarefas")
@Data
@Builder
@AllArgsConstructor
public class Tarefas {

	@Id
	Long id;
	String prioridades; // baixa - media - alta
	String cartegoria;
	String nome;
	
	//servico tera
	//Lista de tarefas semanais onde sera possivel dar check
	
	// na agenda deve aparecer um compo no campo
	// nome com todas essas tarefas para que seja adicionado na agenda
	
}
