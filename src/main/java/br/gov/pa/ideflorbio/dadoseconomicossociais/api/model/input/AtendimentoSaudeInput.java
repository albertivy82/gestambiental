package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.atendimentoSaude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtendimentoSaudeInput {
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private atendimentoSaude tipoAtendimento;
	
	

}
