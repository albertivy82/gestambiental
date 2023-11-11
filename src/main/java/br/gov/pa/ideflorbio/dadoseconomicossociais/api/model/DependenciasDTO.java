package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoDependencia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DependenciasDTO {
	
	private Long id;
	
	private TipoDependencia dependencia;
	
	private int quantidade;
	
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
