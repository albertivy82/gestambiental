package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PescaArtesanalDTO {

	@NotBlank
	private int freqPescaSemanal;
    
	@NotBlank
    private double horasPorDia;
    
   
    private String localDaPesca;
    
   
    private String horarioPrefencialPesca;
    
   
    private float descartePorPescaria;
    
    //ConservacaoTipo
    private String conservacaoPeixe;

    
    //TipoPescariaCusteio
    private String custeio;
    
   
    private double geloPorPescaria;
    
   
    private double custoGeloPorPescaria;
    
   
    private String composicaoRancho;
    
   
    private double custoRanchoPorViagem;
    
   
    private double combustivelPorViagem;
    
   
    private double custoCombustivelPorViagem;
    
   
    private String localDesembarque;
    
      
   
    private double pescaPorSafra;
    
   
    private String localPescaSafra;
    
   
    private String localDeReproducaoPeixe;
    
   
    private String periodoDefeso; 
    
   
    
    private String conheceDefeso;
    
   
    
    private String concordaDefeso;
    
   
    
    private String recebeDefeso;
    
    private BenfeitoriaIdDTO benfeitoria;
    
}
