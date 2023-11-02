package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Exploracao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TamanhoPesca;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
    private String especie;
    
    private double precoVendaMedioKg;
    
    private String importancia;
    
    private String metodosManejoOcorrencia;
    
    private TamanhoPesca reduziuAumentouQtd;
    
    private Exploracao exploracaoNivel;
}