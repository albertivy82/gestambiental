package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeixeInput {

    
    @NotNull
	private String especie;
    
    @NotNull
	private String climaOcorrencia;
		
	@NotNull
	private String locaisEspecificosReprodução;
	
	@NotNull
	private String locaisEspecificosAlimentacao;
	
	@NotNull
	private String maisImportanteDaRegiao;
	
	@NotNull
	private String usosDaEspécie;
	
	@NotNull
	private EntrevistadoIdInput entrevistado;
		
}
