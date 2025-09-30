package br.com.myplanney.core.usuario.model;

import java.util.Collection;
import java.util.List; // Importação necessária para List.of()

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashSet;
import java.util.Set;
import br.com.myplanney.core.enuns.UsuarioRole;
import br.com.myplanney.core.habitos.model.Habitos;
import br.com.myplanney.core.tarefas.model.Tarefas;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, name = "email")
	private String email;

	private String nome;

	private String senha; // O nome 'senha' é um nome comum em português para 'password'

	private UsuarioRole role;

	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Tarefas> tarefas = new  HashSet<Tarefas>(); // O atributo Tarefas deve ser um Collection (como List)

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Habitos> habitos = new HashSet<Habitos>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		
		if (this.role == UsuarioRole.DESENVOLVEDOR) {
			
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}


	@Override
	public String getPassword() {

		return senha;
	}

	@Override
	public String getUsername() {

		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; 
	}




	@Override
	public boolean isEnabled() {
		return true; // Exemplo: Conta ativa
	}


	public Usuario(String email, String nome, String senha, UsuarioRole role) {
		super();
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.role = role;
	}


	public Usuario(Long id, String email, String nome, String senha, UsuarioRole role) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.role = role;
	}

}
