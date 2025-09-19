package br.com.myplanney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.dto.LoginDTO;
import br.com.myplanney.dto.TokenDTO;
import br.com.myplanney.model.Usuario;
import br.com.myplanney.token.TokenService;

@RestController
@RequestMapping("login")
public class LoginControler {

	@Autowired
	TokenService  tokenService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping
	public ResponseEntity<TokenDTO>  login(@RequestBody LoginDTO loginDto){
		
		var userNamePassword = new UsernamePasswordAuthenticationToken(loginDto.email(),loginDto.senha());
		var auth = authenticationManager.authenticate(userNamePassword);
				
		var token = tokenService.criarToken((Usuario) auth.getPrincipal());
		
		TokenDTO tokendto = new TokenDTO(token);
		
		return ResponseEntity.ok(tokendto);
	}
}
