package br.com.myplanney.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.myplanney.nums.UsuarioRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USUARIO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

	@Id
	@Column(unique=true)
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
	
	
}
