package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Grupo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	
	private String nome;
		
	private String matricula;
	
	private String email;
		
	private String cpf;
	
	private List<Localidade> localidadeVinculadas;
	
	private List<Grupo> gupos;


}
