package br.com.myplanney.core.usuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import br.com.myplanney.core.usuario.service.UsuarioService;
import br.com.myplanney.dto.request.UsuarioRequestDTO;
import br.com.myplanney.dto.response.UsuarioResponseDTO;
import br.com.myplanney.infra.security.TokenService;
import br.com.myplanney.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioMapper mapper;

	private final UsuarioService service;

	private final UsuarioRepository usuarioRepository;

	private final TokenService tokenService;

	private final AuthenticationManager authenticationManager;
	

	@PostMapping("/registrar")
	public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody UsuarioRequestDTO usuarioDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(
					mapper.paraUsuarioDTO(
							this.service.salvarUsuario(mapper.paraUsuario(usuarioDto))
							)
					);
	}


	
}
