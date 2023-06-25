package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;


import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntrevistadoIdInput {

	
	@NotNull
	private Long id;

	

}
