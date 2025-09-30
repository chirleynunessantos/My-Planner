package br.com.myplanney.core.habitos.model;

import br.com.myplanney.core.usuario.model.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="habitos")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Habitos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String nome;
	private int quantDiasCheck;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	Usuario usuario;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
