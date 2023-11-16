package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VegetacaoDTO {
	
	private Long id;
	
	private String usoMedicinal;
	
	private String usoAlimentacao;
	
	private String usoOrnamental;
	
	private String usoComercial;
	
	private String usaFlor;
	
	private String usaFolha;
	
	private String usaSemente;
	
	private String usaFruto;
	
	private String usaCasca;
	
	private String usaRaiz;
	
	private String usoLeiteLatex;
	
	private String outrosUsos;
	
	private String coletaLocalPublico;
	
	private String coletaCultivo;
		
	private String coletaCompra;
			
	private String coletaAmbienteEspecifica;
	
	private String quemEnsinouUso;
	
	private String repassaConhecimento;
	
	private String observacoesEspontaneas;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
