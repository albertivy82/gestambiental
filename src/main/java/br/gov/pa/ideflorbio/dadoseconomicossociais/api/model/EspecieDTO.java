package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecieDTO {

    private Long id;
    private String especie;
    private double quantidadePescada;
    private String quantidadeDaPesca;
    private String tamanhoDaPesca;
    private String exploracaoNivel;
    private double precoVendaMedioKg;
    private String importancia;
    private String mesesMaiorOcorrencia;
    private PescaAetesanalIdDTO pescaArtesanal;
}
