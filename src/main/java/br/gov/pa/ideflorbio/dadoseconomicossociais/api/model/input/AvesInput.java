package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvesInput {


	@NotNull
	private String especie;
	
	@NotNull
	private String climaOcorrencia;
		
	@NotNull
	private String usosDaEspécie;
	
	@NotNull
	private String localDeAglomeracao;
	
	@NotNull
	private String problemasGerados;
	
	@NotNull
	private String ameacaSofrida;
	
	@NotNull
	private EntrevistadoIdInput entrevistado;
		
}
