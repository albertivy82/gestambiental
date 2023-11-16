package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstituicaoConhecidaDTO {
	
	private Long id;
	
    private String nome;
	
	private String atividades;
	
	private BenfeitoriaIdDTO benfeitoria;

}
