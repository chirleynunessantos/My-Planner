package br.com.myplanney.model.agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.myplanney.model.tarefas.Tarefas;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
/*@Entity
@Table(name="agenda")
@Data
@Builder*/
public class Agenda {

	LocalTime horario;
	CategoriaAgenda categoria; 
	String tarefa; // na tela aparecera lista que vira de tarfeas
	String diaSemana;
	LocalDateTime data; 
}
