package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.MetodoTratamentoAgua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Poco;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.QualidadeAgua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
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
public class Aves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez possuiForneceimentoPublico;
	
	@Enumerated(EnumType.STRING)
	private QualidadeAgua qualidadeFornecimentoPublico;
	
	private String corAguaForncimentoPublico;
	
	public String saborAguaFornecimentoPublico;


	public String cheiroAguaFornecimentoPublico;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Poco poco;
	
	private double profundidadePoco;
	
	private String corAguaPoco;
	
	public String saborAguaPoco;
	
	public String cheiroAguaPoco;
	
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private MetodoTratamentoAgua tratamentoAgua;
	
		
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
