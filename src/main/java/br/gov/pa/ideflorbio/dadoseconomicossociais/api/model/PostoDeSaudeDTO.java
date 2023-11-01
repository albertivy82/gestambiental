package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class PostoDeSaudeDTO{
	
	private Long id;
	private String nome;
	private String ambulatorial;
	private String urgenciaEmergencia;
	private int medicosPorTurno = 0;
	private LocalidadeIdDTO localidade;
	
	

}
