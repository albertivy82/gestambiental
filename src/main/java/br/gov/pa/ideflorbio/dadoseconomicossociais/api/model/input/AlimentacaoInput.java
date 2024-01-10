package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Alimento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlimentacaoInput {

	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Alimento alimentacaoPrincipal;
	
	
		
}
