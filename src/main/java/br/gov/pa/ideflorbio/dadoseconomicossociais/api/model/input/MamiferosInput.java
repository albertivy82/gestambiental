package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MamiferosInput {

private String especie;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoConsumo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoComercio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoCriacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoRemedio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez usoOutros;
	
	private String problemasRelacionados;
	
	private String alimentacao;
	
	private String desricaoEspontanea;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
