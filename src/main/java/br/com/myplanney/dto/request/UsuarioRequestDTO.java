package br.com.myplanney.dto.request;

import br.com.myplanney.core.enuns.UsuarioRole;

public record UsuarioRequestDTO(String email, String nome, String senha, UsuarioRole role) {

}
