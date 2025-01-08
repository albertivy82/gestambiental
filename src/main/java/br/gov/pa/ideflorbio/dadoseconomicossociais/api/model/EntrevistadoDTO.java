package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EntrevistadoDTO {

	
	 private Long id;
	 private String nome;
	 private String naturalidade;
	 private String nascimentoData;
	 private String sexo;
	 private String apelido;
	 private String escolaridade;
	 private String estadoCivil;
	 private String religiao;
	 private String morador;
	 private String dataChegada;
	 private String pretendeMudar;
	 private String motivoVontadeMudanca;
	 private String relacaoAreaImovel;
	 private String relacaoVizinhos;
	 private String tipoAlimentacao;
	 private String localCompras;
	 private String servicosDeficitarios;
	 private Integer sofreuAssaltos;
	 private Integer presenciouAssalto;
	 private String problemasDeViolenciaLocal;
	 private String conheceUcs;
	 private String conheceUcProposta;
	 private String conheceAreaUc;
	 private String utilizaAreaUc;
	 private String propostaMelhorarArea;
	 private String indicadoConsultaPublica;
	 private String contatoIndicadoConsultaPublica;
	 private LocalidadeIdDTO localidade;
	
		
}
