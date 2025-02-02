package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Documentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EsporteLazer;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.LimitesTerreno;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSolo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoSolo tipoSolo;
	
	@NotBlank
	private String vizinhosConfinantes;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Situacao_Fundiaria situacaoFundiaria;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Documentacao documentacaoImovel;
	

	@Enumerated(EnumType.STRING)
    private LimitesTerreno limites;
	
		
	@NotBlank
	private String linhasDeBarco;
	
	@NotBlank
	private String pavimentacao;
	
	
	@Enumerated(EnumType.STRING)
	private SimNao iluminacaoPublica;
	
	@NotBlank
	private String equipamentosUrbanos;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EsporteLazer esporteLazer;
	
	@NotBlank
	private String programaInfraSaneamento;
	
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "entrevistado") 
	private Entrevistado entrevistado;

	
	
		
}
