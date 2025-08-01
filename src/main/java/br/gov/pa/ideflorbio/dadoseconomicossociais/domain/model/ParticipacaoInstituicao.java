package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParticipacaoInstituicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank 
	private String instituicao;
	
	/*
	 * SINDICATO, COLONIA_DE_PESCA, ASSOCIACAO, CONSELHO, PARTIDO_POLITICO, IGREJA,
	 * NAO_DECLARADO, OUTRO
	 */
	@NotBlank 
	private String tipoDeRegistro;
	 
	@NotBlank 
	private String registro;
	
	@ManyToOne
	@JoinColumn(name="morador")
	private Morador morador;

}
