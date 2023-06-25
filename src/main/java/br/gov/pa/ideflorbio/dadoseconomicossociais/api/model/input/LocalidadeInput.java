package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Municipio;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LocalidadeInput {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Municipio municipio;
	
	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;
	
	
	
	
	
}
