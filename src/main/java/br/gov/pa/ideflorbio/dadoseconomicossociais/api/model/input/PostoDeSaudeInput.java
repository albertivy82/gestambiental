package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostoDeSaudeInput {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao ambulatorial;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao urgenciaEmergencia;
	
	private int medicosPorTurno;
	
	
	@NotNull
	private LocalidadeIdInput localidade;

}
