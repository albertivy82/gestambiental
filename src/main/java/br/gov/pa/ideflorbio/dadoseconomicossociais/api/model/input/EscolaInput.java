package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EscolaInput {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez merenda;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez transporte;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez educacaoAmbiental;
	
	@NotNull
	private LocalidadeIdInput localidade;

}
