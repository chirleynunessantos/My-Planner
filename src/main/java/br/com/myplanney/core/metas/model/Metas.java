package br.com.myplanney.core.metas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

//@Entity
//@Table(name="metas")
//@Data
//@Builder
public class Metas {

	String nomeMeta;
	String tipoMeta;//anual-semestral-mensal-semanal
	
	
	/*Na tela de metas sera apresentado os tipos de metas
	 * o usuario deve preencher a meta anual
	 * podendo adicionar tipos de metas semestrais mensais e nemanais
	 * para poder ir quebrando a meta em pequenas metas*/
	
}
