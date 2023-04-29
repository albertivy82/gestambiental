package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.util.List;
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
	
	private List<GrupoDTO> grupos;


}
