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
public class Peixes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
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
	
		
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
