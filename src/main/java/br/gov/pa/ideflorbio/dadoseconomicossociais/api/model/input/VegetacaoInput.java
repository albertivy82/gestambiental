package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VegetacaoInput {

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
	private SimNaoTalvez usoComercial;
	
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
	private SimNaoTalvez usoLeiteLatex;
	
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
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
