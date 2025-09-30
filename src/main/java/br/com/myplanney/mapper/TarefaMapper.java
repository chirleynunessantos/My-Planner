package br.com.myplanney.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.myplanney.core.tarefas.model.Tarefas;
import br.com.myplanney.dto.request.TarefasRequestDTO;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

	@Mapping(target = "id", ignore= true)
	Tarefas paraTarefa(TarefasRequestDTO tarefaDTO);
}
