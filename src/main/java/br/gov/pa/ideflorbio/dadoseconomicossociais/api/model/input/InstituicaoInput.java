package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InstituicaoInput {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String atividades;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;

}
