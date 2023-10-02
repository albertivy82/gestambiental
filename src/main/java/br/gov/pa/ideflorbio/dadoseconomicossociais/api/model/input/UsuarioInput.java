package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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
	@Email
	private String email;
	
	@NotBlank
	private String cpf;
	
	
	private String senha;
	
	public void setSenha(String cpf) {
	    this.senha = cpf;
	}
	
}
