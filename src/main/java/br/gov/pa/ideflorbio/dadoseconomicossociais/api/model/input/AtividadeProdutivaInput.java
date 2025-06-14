package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.math.BigDecimal;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.AtividadesProdutivas;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeProdutivaInput {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AtividadesProdutivas atividade;
	
	private int pessoasEnvolvidas;
	
	
	@PositiveOrZero(message = "informe um valor válido")
	private BigDecimal faturamentoAtividadeMesTotal;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;

}
