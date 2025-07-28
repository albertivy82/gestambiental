package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EstadoCivil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Sexo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntrevistadoInput {

	
	    private String nome;
	    
	    private String naturalidade;

	    @NotNull
	    private int nascimentoData;

	    @Enumerated(EnumType.STRING)
	    private Sexo sexo;
	    private String apelido;

	    @NotBlank
	    private String escolaridade;

	    @Enumerated(EnumType.STRING)
	    private EstadoCivil estadoCivil;
	    private String religiao;

	    @Enumerated(EnumType.STRING)
	    private SimNao morador;

	    @NotBlank
		private String dataChegada;

	    @NotNull
	    @Enumerated(EnumType.STRING)
	    private SimNaoTalvez pretendeMudar;

	    private String motivoVontadeMudanca;

	    @NotBlank
	    private String relacaoAreaImovel;

	    @NotBlank
	    private String relacaoVizinhos;

	    @NotBlank
	    private String tipoAlimentacao;

	    @NotBlank
	    private String localCompras;

	    
	    private String comoCuidaSaudeFamilia;

	    @NotBlank
	    private String servicosDeficitarios;

	    @NotNull
	    private Integer sofreuAssaltos;

	    @NotNull
	    private Integer presenciouAssalto;

	    @NotBlank
	    private String problemasDeViolenciaLocal;

	    
	    private String instituicaoConhecida;

	    
	    private String importanciaDeProtegerAmbiente;

	   
	    private String importanciaDeProtegerFauna;

	   
	    private String qualEspacoPrecisaSerPreservado;

	    
	    private String problemasRelacionadosAoAmbiente;

	    @Enumerated(EnumType.STRING)
	    private SimNao conheceUcs;

	    @Enumerated(EnumType.STRING)
	    private SimNao conheceUcProposta;

	    @Enumerated(EnumType.STRING)
	    private SimNao conheceAreaUc;

	    @NotBlank
	    private String utilizaAreaUc;

	    @NotBlank
	    private String propostaMelhorarArea;

	    @NotBlank
	    private String indicadoConsultaPublica;

	    @NotBlank
	    private String contatoIndicadoConsultaPublica;

	    @NotNull
	    private LocalidadeIdInput localidade;
	}
