package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaunaDTO {
	
	private Long id;
	
    private String especie;
    
	private String ondeOcorre;
	
	
	private String abundanciaAtual;
	
	
	private String abundanciaPassada;
	
	
	private String tempoQueNaoVe;
	
	
	private String usoDaEspecie;
	
	private EntrevistadoIdDTO entrevistado; 
		
}
