package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViolenciasSofridasDTO {
	
	private Long id;
	private String tipo;
	private int ocorrencias;

}
