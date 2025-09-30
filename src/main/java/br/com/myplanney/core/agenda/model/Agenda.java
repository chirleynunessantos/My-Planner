package br.com.myplanney.core.agenda.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.myplanney.core.enuns.Prioridade;
import br.com.myplanney.core.tarefas.model.Tarefas;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
/*@Entity
@Table(name="agenda")
@Data
@Builder*/
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descricao;
	private LocalTime dataInicio;
	private String local;
	private String categoria;
	private Prioridade prioridade;
	private String status;
	private String diaSemana;
	private String recorrencia; // tera um botao... ai clicar no botar o usuario tera como informar em quais dias
	// essa tarefa ira se repetir e o sistema ira popular sozinho essas datas
	
	
	//terei dois template de agenda uma em lista e outra em calendario
}
