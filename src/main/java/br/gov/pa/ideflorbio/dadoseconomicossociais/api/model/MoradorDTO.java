package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoradorDTO {
	
	private Long id;
	
	private String perfil;
	
	
	private int dataNascimento;
	
	
	private String sexo;
	
	
	private String escolaridade;
	
	
	private String estadoCivil;
	
	private String ondeEstuda;
	
	
	private String trabalho;
	
	
	private String religiao;
	

	private String doencas;
	
	private BenfeitoriaIdDTO benfeitoria;
	
	

}
