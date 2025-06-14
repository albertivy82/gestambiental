package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosComunicacaoDTO {
	
	private Long id;
		
	private String tipoServicoComunicacao;
		
	private String operadoraServicoComunicacao;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
