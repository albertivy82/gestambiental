package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PescaArtesanal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
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
    
    @JsonIgnore
    @OneToMany(mappedBy = "pescaArtesanal")
    private List<DestinoPesca> destinoPesca;
    
    
    @JsonIgnore
	@OneToMany(mappedBy = "pescaArtesanal")
    private List<QuantidadePescaPorTipo> quantidadePescaPorTipo;
    
    @JsonIgnore
	@OneToMany(mappedBy = "pescaArtesanal")
    private List<Embarcacao> embarcacao;
    
    @JsonIgnore
	@OneToMany(mappedBy = "pescaArtesanal")
    private List<Especie> especies;
    
    @NotBlank
    @OneToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;
    
    
    
    
    
    
    
}

