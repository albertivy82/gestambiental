package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoradorDTO {
	
	
	
	private String perfil;
	
	
	private Date dataNascimento;
	
	
	private String sexo;
	
	
	private String escolaridade;
	
	
	private String estadoCivil;
	
	private String ondeEstuda;
	
	
	private String trabalho;
	
	
	private String religiao;
	

	private String doencas;
	
	private BenfeitoriaIdDTO benfeitoria;
	
	

}
