package br.com.myplanney.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.myplanney.security.TokenService;
import br.com.myplanney.usuario.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ConfAuthentication extends OncePerRequestFilter {

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
			UserDetails usuario = repository.findByEmail(login).orElseThrow(()->new RuntimeException("Usuario não encontrado"));
			var userNamePassword = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(userNamePassword);
		
		}else {
			filterChain.doFilter(request, response);
		}
		
	}

}
