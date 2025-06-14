package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BenfeitoriaDTO {
	
	    private Long id;
	    
	    private String tipoBenfeitoria;
	    
	    private String funcao;
	    
	    private String afastamentoDaPrincipal;
	    
	    private String impermeabilizacaoSolo;
	    
	    private String limites;
	    
	    private double areaBenfeitoria;
	    
	    private int pavimentos;
	    
	    private String paredes;
	    
	    private String tipoCobertura;
	    
	    private String tipoEsquadrias;
	    
	    private String origemMadeiraDaConstrucao;
	    
	    private String origemPedraDaConstrucao;
	    
	    private String origemAreiaDaConstrucao;
	    
	    private String alagamentos;

	    private String epocaOcorrencia;

	    private String efluentes;
	        
	    private String residuos;
	    
	    private String fonteEnergia;
	        
	    private String energiaAlimentos;
	    
	    private String meiosLocomocao;
	    
	    private String linhasOnibus;
	        
	    private String informativoPredominante;
	     
	    private ImovelIdDTO imovel;
	

}
