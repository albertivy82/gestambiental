package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaunaInput {
	
	@NotNull
	private String especie;
	
	@NotNull
	private String ondeOcorre;
	
	@NotNull
	private String abundanciaAtual;
	
	@NotNull
	private String abundanciaPassada;
	
	@NotNull
	private String tempoQueNaoVe;
	
	@NotNull
	private String usoDaEspecie;
	
	@NotNull
	private EntrevistadoIdInput entrevistado;
		
}
