package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantidadePescaPorTipoDTO {

    private Long id;
	private String tipoPesca;
	private double quantidadePesca;
	private PescaArtesanalDTO pescaArtesanal; 
}

