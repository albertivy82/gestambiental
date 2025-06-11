package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepteisDTO {
	
	private Long id;
	
	private String especie;
	
	private String local;
	
	private String desova;
	
	private String localDesova;
	
	private String periodoDesova;
	
	private String usoDaEspecie;
	
	private String ameacaParaEspecie;
	
	private String problemasGerados;
	
	private String descricaoEspontanea;
	
	private EntrevistadoIdDTO entrevistado; 
		
}
