package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinoPescaDTO {

    private Long id;
    private String finalidade;
	private double quantidade;
	private String destino;
	private String destinoFixo;
	private int paraQuantos;	
    private PescaArtesanalDTO pescaArtesanal; 
}

