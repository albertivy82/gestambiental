package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordenadaInput {
	
	@NotBlank
	private String coordenada;
	
	@NotNull
	private LocalidadeIdInput localidade;

}
