package br.com.myplanney.core.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.myplanney.core.usuario.model.Usuario;
import br.com.myplanney.core.usuario.repository.UsuarioRepository;
import br.com.myplanney.dto.request.UsuarioRequestDTO;
import br.com.myplanney.dto.response.UsuarioResponseDTO;
import br.com.myplanney.exceptions.UsuarioJaCadastradoException;
import br.com.myplanney.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;

@Service

public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioMapper mapper;

	public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuarioDTO) {

		String senhaCodificada = passwordEncoder.encode(usuarioDTO.senha());

		Usuario usuarioAlterado = new Usuario(usuarioDTO.email(), usuarioDTO.nome(), senhaCodificada,
				usuarioDTO.role());

		if (this.repository.findByEmail(usuarioAlterado.getUsername()).isPresent()) {
			throw new UsuarioJaCadastradoException("Email já cadastrado");
		}
		repository.save(usuarioAlterado);
		return mapper.paraUsuarioDTO(usuarioAlterado);
	}

	public void deletarUsuario(String email) {
	
		 repository.deleteByEmail(email);
	}

	public Usuario alterarUsuario(Usuario usuario) {
		Long id = repository.getIdByEmail(usuario.getEmail());
		Usuario usuarioAlterado = new Usuario(
				id,
				usuario.getEmail(),
				usuario.getNome(), 
				usuario.getSenha(),
				usuario.getRole()
				);
		
	return repository.save(usuarioAlterado);
	}
}
