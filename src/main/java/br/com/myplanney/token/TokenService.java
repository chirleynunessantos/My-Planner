package br.com.myplanney.token;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.myplanney.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class TokenService {
	Algorithm alg = Algorithm.HMAC256("teste");
	
	public String criarToken(Usuario usuario) {
		return JWT.create()				
				.withIssuer("api")				
				.withSubject(usuario.getEmail())
				.sign(alg);				
	}
	
	
	public String buscarLogin(String token) {
		return JWT.require(alg)			
				.withIssuer("api")				
				.build()
				.verify(token)
				.getSubject();
	}
	
	
	public String buscarToken(HttpServletRequest request) {
		
		String token  = request.getHeader("Authorization");
		if(token==null)return null;
		return token.replace("Bearer","").trim();
	}

}
