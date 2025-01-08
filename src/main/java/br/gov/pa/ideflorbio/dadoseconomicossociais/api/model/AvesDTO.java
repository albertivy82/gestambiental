package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvesDTO {
	
	private Long id;
	
	private String especie;
	
	private String usoConsumo;
	
	private String usoComercio;
	
	
	private String usoCriacao;
	
	
	private String usoRemedio;
	
	private String usoOutros;
	
    private String problemasRelacionados;
	
	private String ameacaSofrida;
	
	private String localDeAglomeracao;
	
	private String qualImpotanciaDaEspecie;
	
	private String alimentacao;
	
	private String desricaoEspontanea;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
