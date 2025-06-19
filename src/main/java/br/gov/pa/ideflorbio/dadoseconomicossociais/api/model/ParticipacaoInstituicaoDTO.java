package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipacaoInstituicaoDTO {

	private Long id;
    private String instituicao;
	private String tipoDeRgistro;
	private String Registro;
	private MoradorIdDTO morador; 

}
