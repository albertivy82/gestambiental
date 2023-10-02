package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.util.List;

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
	
	private List<String> grupo;


}
