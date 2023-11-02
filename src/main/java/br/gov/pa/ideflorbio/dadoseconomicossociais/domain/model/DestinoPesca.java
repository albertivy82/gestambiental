package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.HashSet;
import java.util.Set;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.DestinacaoPesca;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private DestinoPesca destino;
	
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez destinoFixo;
	
	private int paraQuantos;	
	
	
	@ManyToMany(mappedBy = "destinoPesca")
	private Set<PescaArtesanal> pescaArtesanal = new HashSet<>();
	
	
	

}
