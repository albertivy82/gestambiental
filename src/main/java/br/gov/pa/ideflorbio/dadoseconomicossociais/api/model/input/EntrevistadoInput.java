package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntrevistadoInput {

	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String apelido;
	
	@NotBlank
	private String naturalidade;
	
	@NotNull
	private ImovelIdInput residencia;
	

}
