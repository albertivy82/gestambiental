package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.MetodoTratamentoAgua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Poco;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.QualidadeAgua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AguaInput {


	
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

	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
