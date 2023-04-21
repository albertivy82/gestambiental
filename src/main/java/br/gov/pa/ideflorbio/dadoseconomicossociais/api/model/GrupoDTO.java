package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoDTO {
	
	
	private Long id;
	
	private String nome;
	
	private List<PermissaoDTO> permissao;
	
	
}
