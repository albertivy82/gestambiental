package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.ServicoPublicos;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosBasicosInput {
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ServicoPublicos servicosDeficitarios;
	
	

}
