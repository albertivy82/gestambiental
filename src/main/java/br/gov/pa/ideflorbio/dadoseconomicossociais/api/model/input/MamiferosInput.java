package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MamiferosInput {

	@NotNull
	private String especie;
	
	@NotNull
	private String local;
	
	@NotNull
	private String usoDaEspecie;
	
	@NotNull
	private String problemasGerados;
	
	@NotNull
	private String alimentacao;
	
	private String desricaoEspontanea;
	
	@NotNull
	private EntrevistadoIdInput entrevistado;
		
}
