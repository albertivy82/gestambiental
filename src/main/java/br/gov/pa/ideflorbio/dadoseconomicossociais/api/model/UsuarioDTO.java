package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private Long id;
	
	private String nome;
		
	private String matricula;
	
	private String email;
		
	private String cpf;
	
	private GrupoNomeDTO grupo;


}
