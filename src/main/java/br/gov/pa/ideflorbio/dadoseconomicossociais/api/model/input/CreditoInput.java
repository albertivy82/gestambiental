package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditoInput {
	
	private String nome;
		
	@PositiveOrZero(message = "informe um valor válido")
	private BigDecimal valor;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;

}
