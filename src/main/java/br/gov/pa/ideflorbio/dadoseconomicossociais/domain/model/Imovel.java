package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
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
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Imovel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String rua;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String referencial;
	
	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;
	
	@NotNull
	private double areaImovel;
	
	@NotBlank
	private String tipoSolo;
	
	@NotBlank
	private String vizinhosConfinantes;
	
	
	@NotBlank
	private String situacaoFundiaria;
	
	@NotBlank
	private String documentacaoImovel;
	

	@NotBlank
    private String limites;
	
		
	@NotBlank
	private String linhasDeBarco;
	
	@NotBlank
	private String pavimentacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao iluminacaoPublica;
	
	@NotBlank
	private String equipamentosUrbanos;
	
	@NotBlank
	private String espacosEsporteLazer;
	
	@NotBlank
	private String programaInfraSaneamento;
	
	@JsonIgnore
	@OneToMany(mappedBy="imovel")
	private List<Benfeitoria> benfeitoria = new ArrayList<>();
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "entrevistado") 
	private Entrevistado entrevistado;

	
	
		
}
