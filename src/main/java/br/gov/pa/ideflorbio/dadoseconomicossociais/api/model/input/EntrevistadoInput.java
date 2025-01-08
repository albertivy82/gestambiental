package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Escolaridade;
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
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date nascimentoData;
	
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	private String apelido;
	
	
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
	
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	private String religiao;
	
	@Enumerated(EnumType.STRING)
	private SimNao morador;
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataChegada;
	
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
	
	
	@NotBlank
	private String servicosDeficitarios;
	
	@NotNull
	private Integer sofreuAssaltos;

	@NotNull
	private Integer presenciouAssalto;

	@NotBlank
	private String problemasDeViolenciaLocal;

	
	@Enumerated(EnumType.STRING)
	private SimNao conheceUcs;
	
	@Enumerated(EnumType.STRING)
	private SimNao conheceUcProposta;
	
	
	@Enumerated(EnumType.STRING)
	private SimNao conheceAreaUc;
	

	@Enumerated(EnumType.STRING)
	private SimNao utilizaAreaUc;
	
	private String propostaMelhorarArea;
	
	private String indicadoConsultaPublica;
	
	private String contatoIndicadoConsultaPublica;
	
	@NotNull
    private LocalidadeIdInput localidade;
	

}
