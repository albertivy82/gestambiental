package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vegetacao {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	private String especie;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoMedicinal;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoAlimentacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoOrnamental;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoComercial;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usaFlor;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usaFolha;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usaSemente;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usaFruto;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usaCasca;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usaRaiz;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao usoLeiteLatex;
	
	@NotNull
	private String outrosUsos;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao coletaLocalPublico;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao coletaCultivo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao coletaCompra;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao coletaAmbienteEspecifica;
	
	
	private String quemEnsinouUso;
	
	private String repassaConhecimento;
	
	private String observacoesEspontaneas;
	
	@ManyToOne
	@JoinColumn(name="entrevistado")
	private Entrevistado entrevistado;
	
	
	
	
}
