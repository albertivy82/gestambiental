package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.ServicoPublicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.atendimentoSaude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosBasicosInput {
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private atendimentoSaude tipoAtendimento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ServicoPublicos servicosDeficitarios;
	
	@NotNull
	private ImovelIdInput residencia;
	
	

}
