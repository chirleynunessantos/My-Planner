package br.com.myplanney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.dto.UsuarioDTO;
import br.com.myplanney.model.Usuario;
import br.com.myplanney.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		
		String senha = new BCryptPasswordEncoder().encode(usuarioDto.senha());
		
		Usuario usuario = new Usuario(usuarioDto.email(), usuarioDto.nome(), senha, usuarioDto.role());
		service.salvarUsuario(usuario);
		return ResponseEntity.ok(usuarioDto);
		
	
	}
}
