package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
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
	private SimNao ocorreMata;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao ocorreRio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao ocorreLago;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao ocorreRua;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao ocorreQuintal;
	
	@NotNull
	private String outrasOcorrencias;
	
	@NotNull
	private String frequenciaAtual;
	
	@NotNull
	private String frequenciaPassada;
	
	@NotNull
	private String tempoQueNaoVe;
	
	@ManyToOne
	@JoinColumn(name="entrevistado")
	private Entrevistado entrevistado;

}
