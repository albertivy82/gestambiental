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
	private String local;
	
	@NotNull
	private String desova;
	
	private String localDesova;
	
	private String periodoDesova;
	
	@NotNull
	private String usoDaEspecie;
	
	@NotNull
	private String ameacaParaEspecie;
	
	@NotNull
	private String problemasGerados;
	
	private String descricaoEspontanea;
	
	@NotNull
	private EntrevistadoIdInput entrevistado;
		
}
