package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalidadeDTO {
	
    
	private Long id;
	
	private String nome;
	
	private String municipio;
	
	private String latitude;
	
	private String longitude;
	
	private List<PostoDeSaudeDTO> posto;
	
	private List<ImovelToLocaliadadeDTO> residencia;
	
	private List<EscolaToLocalidadeDTO> escola;
	
	private List<CoordenadaDTO> coordenadas;
	
	
		
	
}
