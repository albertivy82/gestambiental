package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeixesDTO {
	
	private Long id;
	
private String especie;
	
	
	
	
	private String locaisEspeciais;
	
	
	
	private String locaisEspecificosAlimentacao;
	
	
	
	private String usoAlimnetacao;
	
	
	
	private String usoComercio;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
