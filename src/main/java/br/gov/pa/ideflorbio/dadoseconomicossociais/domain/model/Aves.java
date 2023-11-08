package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

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
public class Aves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String especie;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoConsumo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoComercio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoCriacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoremedio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoOutros;
	
	private String priblemasRelacionados;
	
	private String ameacaSofrida;
	
	private String localDeAglomeracao;
	
	private String qualImpotanciaDaEspecie;
	
	private String alimmentacao;
	
	private String desricaoEspontanea;
	
		
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
