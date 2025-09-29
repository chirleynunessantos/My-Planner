package br.com.myplanney.dto.response;

import br.com.myplanney.core.enuns.UsuarioRole;

public record UsuarioResponseDTO(String email, String nome,UsuarioRole role) {
 

}
