package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.math.BigDecimal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.FontesRenda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RendasOutrasFontesInput {
	
	@Enumerated(EnumType.STRING)
	private FontesRenda fonte;
	
	
	private int beneficiarios;
	
	@PositiveOrZero(message = "informe um valor válido")
	private BigDecimal rendaMesTotal;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;

}
