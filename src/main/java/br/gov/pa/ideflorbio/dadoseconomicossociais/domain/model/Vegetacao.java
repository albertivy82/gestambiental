package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
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
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoMedicinal;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoAlimentacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoOrnamental;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usocomercial;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usaFlor;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usaFolha;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usaSemente;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usaFruto;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usaCasca;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usaRaiz;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usLeiteLatex;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez outrosUsos;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez coletaLocalPublico;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez coletaCultivo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez coletaCompra;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez coletaAmbienteEspecifica;
	
	
	private String quemEnsinouUso;
	
	private String repassaConhecimento;
	
	private String observacoesEspontaneas;
	
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;
	
	
	
	
}
