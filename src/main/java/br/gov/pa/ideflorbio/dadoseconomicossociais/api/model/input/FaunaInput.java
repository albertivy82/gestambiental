package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Ocorrencia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TempoQueNaoAvista;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaunaInput {

private String especie;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez ocorreMata;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez ocorreRio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez ocorreLago;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez ocorreRua;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez ocorreQuintal;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez outrasOcorrencias;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Ocorrencia ferequenciaAtual;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Ocorrencia ferequenciaPassada;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TempoQueNaoAvista tempoQueNaoVe;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
