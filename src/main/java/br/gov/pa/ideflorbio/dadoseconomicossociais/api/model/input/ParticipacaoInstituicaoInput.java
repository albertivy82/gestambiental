package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipacaoInstituicaoInput {

    
    private String instituicao;
	
	private String tipoDeRgistro;
	
	private String Registro;
	
	@NotNull
	private MoradorIdInput morador;
		
}
