package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaunaDTO {
	
	private Long id;
	
private String especie;
	
	
	
	
	private String ocorreMata;
	
	
	
	private String ocorreRio;
	
	
	
	private String ocorreLago;
	
	
	
	private String ocorreRua;
	
	
	
	private String ocorreQuintal;
	
	
	
	private String outrasOcorrencias;
	
	
	
	private String ferequenciaAtual;
	
	
	
	private String ferequenciaPassada;
	
	
	
	private String tempoQueNaoVe;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
