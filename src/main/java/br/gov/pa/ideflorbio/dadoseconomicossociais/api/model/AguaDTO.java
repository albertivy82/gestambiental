package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AguaDTO {
	
	private Long id;
	
	private String tipoDeFornecimento;
	
	private String qualidadeDaAgua;
	
	private String metodoTratamento;
	
	private String corDagua;
	
	private String cheiroDagua;
	
	private String saborDagua;
	
	private double profundidadePoco;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
