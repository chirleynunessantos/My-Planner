package br.com.myplanney.dto.response;

import java.time.LocalTime;

import br.com.myplanney.core.enuns.Prioridade;

public record AgendaResponseDTO(
		String titulo, String descricao, LocalTime dataInicio, String local, String categoria,
		Prioridade prioridade,String status, String diaSemana, String recorrencia) {

}
