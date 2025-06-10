package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class QuantidadePescaPorTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	private String tipoPesca;
	
	/*
	 * CANICO("Caniço"), LINHA_DE_MAO("Linha de Mão"), MALHADEIRA("Malhadeira"),
	 * TARRAFA("Tarrafa"), ARPÃO("Arpão"), MATAPI("Matapi"), OUTROS("Outros");
	 */
	
	private double quantidadePesca;
	
	@ManyToOne
	@JoinColumn(name="pescaArtesanal")
    private PescaArtesanal pescaArtesanal;

	
	
	
	
}
