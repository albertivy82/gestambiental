package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Molestias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoencaInput {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Molestias doencaNome;

}
