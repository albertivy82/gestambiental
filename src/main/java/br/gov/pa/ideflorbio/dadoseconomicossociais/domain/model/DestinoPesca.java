package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.DestinacaoPesca;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.DestinoPescado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
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
public class DestinoPesca {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private DestinacaoPesca destinacao;
	
	private double quantidade;
	
	@Enumerated(EnumType.STRING)
	private DestinoPescado destino;
	
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez destinoFixo;
	
	private int paraQuantos;	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="pescaArtesanal")
	private PescaArtesanal pescaArtesanal;
	
	
	

}
