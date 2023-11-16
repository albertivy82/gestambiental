package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViolenciasSofridasDTO {
	
	private Long id;
	private String tipo;
	private String condicao;
	private int ocorrencias;
	private String destaqueDoMorador;
	private BenfeitoriaIdDTO benfeitoria; 

}
