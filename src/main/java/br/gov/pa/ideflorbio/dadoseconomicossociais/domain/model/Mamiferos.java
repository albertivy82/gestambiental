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
public class Mamiferos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String especie;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoConsumo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoComercio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoCriacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoRemedio;
	
	@NotNull
	private String usoOutros;
	
	private String problemasRelacionados;
	
	private String alimentacao;
	
	private String desricaoEspontanea;
	
		
	@ManyToOne
	@JoinColumn(name="entrevistado")
	private Entrevistado entrevistado;

}
