package br.com.myplanney.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	TokenService tokenService;
	@Autowired
	UsuarioRepository repository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
	    
	    var token = tokenService.buscarToken(request);
	    
	    if(token != null) {
	        var login = tokenService.buscarLogin(token);
	        
	        // Use findByEmail para garantir que o resultado da busca exista
	        UserDetails usuario = repository.findByEmail(login)
	            .orElse(null); // Retorna null se não encontrar o usuário

	        if(usuario != null) {
	            var userNamePassword = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
	            SecurityContextHolder.getContext().setAuthentication(userNamePassword);
	        }
	    }
	    
	    // ESTE É O PONTO CRÍTICO: Chame o próximo filtro/controller SEMPRE.
	    // Se o token for válido, o usuário já estará no contexto.
	    // Se o token for nulo ou inválido, o próximo filtro (Authorizer) bloqueará a requisição se for para um endpoint protegido.
	    filterChain.doFilter(request, response);
	}

}
