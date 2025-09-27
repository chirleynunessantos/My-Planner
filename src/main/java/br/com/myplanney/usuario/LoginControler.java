package br.com.myplanney.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.dto.LoginDTO;
import br.com.myplanney.dto.TokenDTO;
import br.com.myplanney.dto.UsuarioDTO;
import br.com.myplanney.security.TokenService;
import br.com.myplanney.usuario.model.Usuario;
import br.com.myplanney.usuario.repository.UsuarioRepository;
import br.com.myplanney.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginControler {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UsuarioService service;
	private final UsuarioRepository usuarioRepository;
	private final TokenService  tokenService;	
	private final AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDto){
		
		Usuario usuario = (Usuario) usuarioRepository.findByEmail(loginDto.email()).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
		if(bCryptPasswordEncoder.matches(loginDto.senha(),usuario.getSenha())) {
			var token = tokenService.criarToken(usuario);
			TokenDTO tokendto = new TokenDTO(token);
			return ResponseEntity.ok(tokendto);
		}else {
			return ResponseEntity.badRequest().build();
		}
		/*
		var userNamePassword = new UsernamePasswordAuthenticationToken(loginDto.email(),loginDto.senha());
		var auth = authenticationManager.authenticate(userNamePassword);
				
		
		TokenDTO tokendto = new TokenDTO(token);
		*/
		
	}
		
	@PostMapping("/registrar")
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDto) {
		
		// 1. Valida se o usuário já existe
		if (this.usuarioRepository.findByEmail(usuarioDto.email()).isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
				
		// 2. Codifica a senha antes de salvar
		String senhaCodificada = bCryptPasswordEncoder.encode(usuarioDto.senha());
		
		// 3. Cria e salva o novo usuário
		Usuario usuario = new Usuario(usuarioDto.email(), usuarioDto.nome(), senhaCodificada, usuarioDto.role());
		this.service.salvarUsuario(usuario);
		
		// 4. Retorna a resposta com o DTO do usuário
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
	}
}
