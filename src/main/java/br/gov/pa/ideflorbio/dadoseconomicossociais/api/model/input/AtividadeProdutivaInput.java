package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeProdutivaInput {
	
	@NotBlank
	private String atividade;
	
	private int pessoasEnvolvidas;
	
	
	@PositiveOrZero(message = "informe um valor válido")
	private BigDecimal faturamentoAtividadeMesTotal;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;

}
