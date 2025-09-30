package br.com.myplanney.core.tarefas.model;

import br.com.myplanney.core.enuns.Prioridade;
import br.com.myplanney.core.usuario.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Entity
@Table(name="tarefas")
@Getter
@Setter
public class Tarefas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Prioridade prioridade; // baixa - media - alta
	private String categoria;
	private String nome;
	private String concluido;
	
	@ManyToOne
	@JoinColumn(name= "usuario_id", nullable = false)
	private Usuario usuario;
	
	public Tarefas(Prioridade prioridade, String categoria, String nome, Usuario usuario) {
		super();
		this.prioridade = prioridade;
		this.categoria = categoria;	// na agenda deve aparecer um compo no campo
		this.nome = nome;
		this.usuario = usuario;
	}
		
}
