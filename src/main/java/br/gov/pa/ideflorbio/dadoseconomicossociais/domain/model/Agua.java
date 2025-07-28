package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.QualidadeAgua;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Agua {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String tipoDeFornecimento;
	
	@Enumerated(EnumType.STRING)
	private QualidadeAgua qualidadeDaAgua;
	
	@NotBlank
	private String metodoTratamento;
	
	private String corDagua;
	
	private String cheiroDagua;
	
	private String saborDagua;
	
	private double profundidadePoco;
	
	@ManyToOne
	@JoinColumn(name = "benfeitoria")
	private Benfeitoria benfeitoria;
	
	
		

}
