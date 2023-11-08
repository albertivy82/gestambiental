package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmbarcacaoDTO {

	private Long id;
    private String numeracao;
    private String tipoBarco;
    private String tipoCasco;
    private PescaArtesanalDTO pescaArtesanal; 
}