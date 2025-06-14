package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PescaArtesanalInput {

   
	@NotBlank
	private int freqPescaSemanal;
    
	@NotBlank
    private double horasPorDia;
    
    @NotBlank
    private String localDaPesca;
    
    @NotBlank
    private String horarioPrefencialPesca;
    
    @NotBlank
    private float descartePorPescaria;
    
    //ConservacaoTipo
    private String conservacaoPeixe;

    
    //TipoPescariaCusteio
    private String custeio;
    
    @NotBlank
    private double geloPorPescaria;
    
    @NotBlank
    private double custoGeloPorPescaria;
    
    @NotBlank
    private String composicaoRancho;
    
    @NotBlank
    private double custoRanchoPorViagem;
    
    @NotBlank
    private double combustivelPorViagem;
    
    @NotBlank
    private double custoCombustivelPorViagem;
    
    @NotBlank
    private String localDesembarque;
    
      
    @NotBlank
    private double pescaPorSafra;
    
    @NotBlank
    private String localPescaSafra;
    
    @NotBlank
    private String localDeReproducaoPeixe;
    
    @NotBlank
    private String periodoDefeso; 
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private SimNao conheceDefeso;
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private SimNao concordaDefeso;
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private SimNao recebeDefeso;
    
    @NotNull
	private BenfeitoriaIdInput benfeitoria;

  
}
