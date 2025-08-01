package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipacaoInstituicaoInput {

	@NotBlank 
    private String instituicao;
	
	@NotBlank 
	private String tipoDeRegistro;
	
	@NotBlank 
	private String registro;
	
	@NotNull
	private MoradorIdInput morador;
		
}
