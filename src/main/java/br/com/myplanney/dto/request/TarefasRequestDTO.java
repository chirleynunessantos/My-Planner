package br.com.myplanney.dto.request;

import br.com.myplanney.core.enuns.Prioridade;

public record TarefasRequestDTO( Prioridade prioridade, String categoria, String nome,String concluido) {

}
