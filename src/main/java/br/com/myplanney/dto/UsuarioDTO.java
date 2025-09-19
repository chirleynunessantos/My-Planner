package br.com.myplanney.dto;

import br.com.myplanney.nums.UsuarioRole;

public record UsuarioDTO(String email, String nome, String senha, UsuarioRole role) {

}
