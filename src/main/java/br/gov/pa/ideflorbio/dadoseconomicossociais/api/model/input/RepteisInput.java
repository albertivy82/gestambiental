package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepteisInput {

   private String especie;
	
	private String local;
	
	private String periodo;
	
	private String uso;
	
	private String ameacado;
	
	private String problemasRelacionados;
	
	private String cacado;
	
	private String desricaoEspontanea;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
