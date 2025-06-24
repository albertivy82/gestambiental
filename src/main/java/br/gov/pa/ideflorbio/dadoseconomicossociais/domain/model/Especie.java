package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Exploracao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TamanhoPesca;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
    private String especie;
    
    @NotBlank
    private double quantidadePescada;
    
    @Enumerated(EnumType.STRING)
    private TamanhoPesca tamanhoDaPesca;
    
    @Enumerated(EnumType.STRING)
    private Exploracao exploracaoNivel;
    
    @NotBlank
    private double precoVendaMedioKg;
    
    @NotBlank
    private String importancia;
    
    @NotBlank
    private String mesesMaiorOcorrencia;
    
    @ManyToOne
	@JoinColumn(name="pescaArtesanal")
    private PescaArtesanal pescaArtesanal;

    
  
}