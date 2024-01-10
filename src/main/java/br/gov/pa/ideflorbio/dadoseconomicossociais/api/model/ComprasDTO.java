package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComprasDTO {
	
	private Long id;
	
	private String ondeFazCompras;
	
	private String detalheLocalDeCompras;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
