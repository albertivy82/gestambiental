package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDTO {
	
	private Long id;
	
    private String rua;
	
	private String numero = "S/N";
	
	private String bairro;
	
	private String referencial;
	
	private String latitude;
	
	private String longitude;
	
	private double areaImovel;
	
	private String vizinhos = "NAO_DECLARADO";
	
	private String situacaoFundiaria;
	
	private String documentacaoImovel;
	
	private String dataChegada;
	
	private String pretendeMudar;

	private String MotivoVontadeMudanca = "NÃO SE APLICA";
	
	private String relacaoArea;
	
	private String relacaoVizinhos;
	
	private String limites;
	
	private String iluminacaoPublica;
	
	private String transporte;
	
	private String programaInfraSaneamento= "NÃO INFORMADO";;
	
	private String linhasDeBarco;
	
	private String tipoSolo;
	
	private String esporteLazer;
	
	private EntrevistadoIdDTO localidade;

}
