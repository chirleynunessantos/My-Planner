package br.com.myplanney.core.usuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import br.com.myplanney.core.usuario.service.UsuarioService;
import br.com.myplanney.dto.request.LoginRequestDTO;
import br.com.myplanney.dto.request.UsuarioRequestDTO;
import br.com.myplanney.dto.response.TokenResponseDTO;
import br.com.myplanney.dto.response.UsuarioResponseDTO;
import br.com.myplanney.infra.security.TokenService;
import br.com.myplanney.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService service;

	private final UsuarioRepository usuarioRepository;

	private final TokenService tokenService;

	private final AuthenticationManager authenticationManager;
	
	private final UsuarioMapper mapper;
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO requestDTO){
		
		var userNamePassword = new UsernamePasswordAuthenticationToken(requestDTO.email(), requestDTO.senha());
		
		var auth = authenticationManager.authenticate(userNamePassword);
		
		String token = tokenService.criarToken((Usuario) auth.getPrincipal());
		
		TokenResponseDTO resp = new  TokenResponseDTO(token);
		
	return ResponseEntity.ok(resp);
	}

	

	@PostMapping("/registrar")
	public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody UsuarioRequestDTO usuarioDto) {
		
		return 	ResponseEntity.status(HttpStatus.CREATED).body(service.salvarUsuario(usuarioDto));
	}

	@DeleteMapping("/{email}")
	public ResponseEntity<String> deletarUsuario(@PathVariable("/{email}") String email ) {		
		return 	ResponseEntity.status(HttpStatus.CREATED).body("Sucesso");
	}

	@PostMapping
	public ResponseEntity<UsuarioResponseDTO> alterarUsuario(@RequestBody UsuarioRequestDTO usuarioDto) {
		
		return 	ResponseEntity.status(HttpStatus.CREATED).body(
				mapper.paraUsuarioDTO(
						service.alterarUsuario(
								mapper.paraUsuario(usuarioDto)
								)
						)
				);
	}

}
