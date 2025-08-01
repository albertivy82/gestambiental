package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoDependencia;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DependenciasInput {

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDependencia dependencia;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
