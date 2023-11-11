package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Alimentacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosDeConsumoInput {

	@NotNull
	@Enumerated(EnumType.STRING)
	private Alimentacao alimentacaoPrincipal;
	
	@NotBlank
	private String LocalDeCompras;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
