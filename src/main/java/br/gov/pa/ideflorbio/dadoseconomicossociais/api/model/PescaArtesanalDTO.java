package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PescaArtesanalDTO {

    private Long id;
    private int freqPescaSemanal;
    private double horasPorDia;
    private String localDaPesca;
    private String horarioPrefencialPesca;
    private float descartePorPescaria;
    private List<String> conservacaoPeixe;
    private List<String> custeio;
    private double geloPorPescaria;
    private double custoGeloPorPescaria;
    private String composicaoRancho;
    private double custoRanchoPorViagem;
    private double combustivelPorViagem;
    private double custoCombustivelPorViagem;
    private String localDesembarque;
    private String conservacaoTipo;
    private double pescaPorSafra;
    private String localPescaSafra;
    private String localDeReproducaoPeixe;
    private String periodoDefeso;
    private String conheceDefeso;
    private String concordaDefeso;
    private String recebeDefeso;
    private BenfeitoriaIdDTO benfeitoria;
    
}
