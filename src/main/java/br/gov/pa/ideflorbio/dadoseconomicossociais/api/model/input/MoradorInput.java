package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MoradorInput {
	
	@NotBlank
	private String perfil;
	
	@NotNull
	private int dataNascimento;
	
	@NotBlank
	private String sexo;
	
	@NotBlank
	private String escolaridade;
	
	@NotBlank
	private String estadoCivil;
	
	@NotBlank
	private String ondeEstuda;
	
	@NotBlank
	private String trabalho;
	
	@NotBlank
	private String religiao;
	
	@NotBlank
	private String doencas;
	//ver arquivo moléstias
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;


}
