package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvesDTO {
	
	private Long id;
	
	private String especie;
	
	private String climaOcorrencia;
	
	private String usosDaEspecie;
	
	private String localDeAglomeracao;
	
	private String problemasGerados;
	
	private String ameacaSofrida;
	
	private EntrevistadoIdDTO entrevistado; 
		
}
