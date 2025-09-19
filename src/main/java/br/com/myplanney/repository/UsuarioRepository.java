package br.com.myplanney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.myplanney.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	UserDetails findByEmail(String email);
}
