package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeixesDTO {
	
    private Long id;
	
	private String especie;
	
	private String climaOcorrencia;
		
	private String locaisEspecificosReproducao;
	
	private String locaisEspecificosAlimentacao;
		
	private String maisImportanteDaRegiao;

	private String usosDaEspecie;
	
	private EntrevistadoIdDTO entrevistado; 
		
}
