package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Ocorrencia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TempoQueNaoAvista;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fauna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
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
	private Ocorrencia ferequanciaAtual;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Ocorrencia ferequanciaPassada;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TempoQueNaoAvista tempoQueNaove;
	
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
