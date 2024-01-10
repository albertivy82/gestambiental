package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.LocalCompras;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComprasInput {

	
	@NotNull
	@Enumerated(EnumType.STRING)
	private LocalCompras ondeFazCompras;
	
	private String detalheLocalDeCompras;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
