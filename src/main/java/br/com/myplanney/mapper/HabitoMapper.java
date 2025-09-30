package br.com.myplanney.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.myplanney.core.habitos.model.Habitos;
import br.com.myplanney.dto.request.HabitoRequestDTO;
import br.com.myplanney.dto.response.HabitoResponsetDTO;

@Mapper( componentModel = "spring")
public interface HabitoMapper {

	@Mapping(target = "id", ignore= true)
	Habitos paraHabitos(HabitoRequestDTO habitoRequestDTO);
	
	HabitoResponsetDTO paraHabitoResponsetDTO(Habitos habitos);

}
