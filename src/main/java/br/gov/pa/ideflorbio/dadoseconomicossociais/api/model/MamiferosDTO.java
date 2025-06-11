package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MamiferosDTO {
	
	private Long id;
	
	private String especie;
	
	private String local;
	
	private String usoDaEspecie;
		
	private String problemasGerados;
	
	private String alimentacao;
	
	private String desricaoEspontanea;
	
	private EntrevistadoIdDTO entrevistado; 
		
}
