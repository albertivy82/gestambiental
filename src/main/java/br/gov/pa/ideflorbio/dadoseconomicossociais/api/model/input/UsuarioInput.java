package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
	
	@NotBlank
	private String Nome;
	@NotBlank
	private String matricula;
	@NotBlank
	private String email;
	@NotBlank
	private String cpf;
	

}
