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

    private String tipoSolo;

    private String vizinhosConfinantes = "NAO_DECLARADO";

    private String situacaoFundiaria;

    private String documentacaoImovel;

    private String limites;

    private String linhasDeBarco;

    private String pavimentacao;

    private String iluminacaoPublica;

    private String equipamentosUrbanos;

    private String espacosEsporteLazer;

    private String programaInfraSaneamento = "NÃO INFORMADO";

    private EntrevistadoIdDTO entrevistado;

}
