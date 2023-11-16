package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepteisDTO {
	
	private Long id;
	
    private String especie;
	
	private String local;
	
	private String periodo;
	
	private String uso;
	
	private String ameacado;
	
	private String problemasRelacionados;
	
	private String cacado;
	
	private String desricaoEspontanea;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
