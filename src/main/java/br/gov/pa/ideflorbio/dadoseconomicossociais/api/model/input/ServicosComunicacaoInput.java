package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Operadora;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoServicComunicacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosComunicacaoInput {

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoServicComunicacao tipoServicoComunicacao;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Operadora operadoraServicoComunicacao;
	
	@NotNull
	private BenfeitoriaIdInput benfeitoria;
		
}
