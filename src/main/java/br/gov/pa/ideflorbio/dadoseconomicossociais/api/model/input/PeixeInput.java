package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeixeInput {

    private String especie;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez locaisEspeciais;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez locaisEspecificosAlimentacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoAlimnetacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoComercio;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
