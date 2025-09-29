package br.com.myplanney.core.usuario.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.myplanney.core.enuns.UsuarioRole;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	@Column(unique=true,name="email")
	private String email;
	
	private String nome;
	
	private String senha;
	
	private UsuarioRole role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		if(this.role == UsuarioRole.DESENVOLVERDOR) {
			return List.of(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));
		}
		return List.of(new SimpleGrantedAuthority("USER"));	}
	@Override
	public String getPassword() {
		return senha;
	}
	@Override
	public String getUsername() {
		
		return email;
	}
	public Usuario(String email2, String nome2, String senha2, UsuarioRole role2) {
		this.email=email2;
		this.nome = nome2;
		this.senha = senha2;
		this.role = role2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioRole getRole() {
		return role;
	}
	public void setRole(UsuarioRole role) {
		this.role = role;
	}
	
	
}
