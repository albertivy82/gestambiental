package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.QualidadeAgua;
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
	private String tipoDeFornecimento;
	
	@Enumerated(EnumType.STRING)
	private QualidadeAgua qualidadeDaAgua;
	
	@NotBlank
	private String metodoTratamento;
	
	private String corDagua;
	
	private String cheiroDagua;
	
	private String saborDagua;
	
	private double profundidadePoco;
	
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
	

}
