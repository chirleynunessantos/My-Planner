package br.com.myplanney.core.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.myplanney.core.usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<UserDetails> findByEmail(String email);

	void deleteByEmail(String email);

	Long getIdByEmail(String email);


}
