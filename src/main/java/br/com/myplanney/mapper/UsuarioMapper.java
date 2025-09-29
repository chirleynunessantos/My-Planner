package br.com.myplanney.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
// Remova: import org.springframework.stereotype.Component;

import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.dto.request.UsuarioRequestDTO;
import br.com.myplanney.dto.response.UsuarioResponseDTO;

@Mapper(componentModel = "spring") // Isso é o suficiente para o Spring
public interface UsuarioMapper {

	@Mapping(target="id", ignore=true)
	Usuario paraUsuario(UsuarioRequestDTO usuarioRequestDTO);
	
// Geralmente, o ID não deve ser ignorado no DTO de resposta.

	UsuarioResponseDTO paraUsuarioDTO(Usuario usuario);
}