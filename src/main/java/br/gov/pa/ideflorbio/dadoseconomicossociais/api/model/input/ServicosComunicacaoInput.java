package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosComunicacaoInput {

	@NotBlank
	private String tipoServicoComunicacao;
	
	@NotBlank
	private String operadoraServicoComunicacao;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
