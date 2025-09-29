 package br.com.myplanney.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.myplanney.core.usuario.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String chave;

	
	public String criarToken(Usuario usuario) {
		try {
			Algorithm algoritimo = Algorithm.HMAC256(chave);
			String token = JWT.create()				
					.withIssuer("api-myplanner")	
					.withExpiresAt(tempoToken())
					//.withSubject(usuario.getEmail())				    
					.sign(algoritimo);	
					
			return token;	
		}catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao autenticar");
		}
			
	}
	



	public String buscarLogin(String token) {
		try {
			Algorithm algoritimo = Algorithm.HMAC256(chave);
			String email = JWT.require(algoritimo)			
					.withIssuer("api-myplanner")				
					.build()
					.verify(token)
					.getSubject();
			
			return email;
		} catch (JWTVerificationException e) {
			return null;
		}
	
	
	}
	
	
	public String buscarToken(HttpServletRequest request) {		
		String token  = request.getHeader("Authorization");
		if(token==null)return null;
		return token.replace("Bearer","").trim();
	}
	private Instant tempoToken() {	
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));		
	}
	

	
}
