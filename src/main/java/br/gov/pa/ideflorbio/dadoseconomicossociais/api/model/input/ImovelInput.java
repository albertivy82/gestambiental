package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Documentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EsporteLazer;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.LimitesTerreno;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSolo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ImovelInput {
	    
	
	  @NotBlank
	    private String rua;

	    @NotBlank 
	    private String numero;

	    @NotBlank 
	    private String bairro;

	    @NotBlank
	    private String referencial;

	    @NotBlank
	    private String latitude;

	    @NotBlank
	    private String longitude;

	    @NotNull
	    private double areaImovel;
	    
	    @NotNull 
	    @Enumerated(EnumType.STRING)
	    private TipoSolo tipoSolo;
	    
	    @NotBlank
	    private String vizinhosConfinantes;

	    @NotNull 
	    @Enumerated(EnumType.STRING)
	    private Situacao_Fundiaria situacaoFundiaria;

	    @NotNull 
	    @Enumerated(EnumType.STRING)
	    private Documentacao documentacaoImovel;

	    @NotNull 
	    @Enumerated(EnumType.STRING)
	    private LimitesTerreno limites;

	    @NotBlank
	    private String linhasDeBarco;

	    @NotBlank
	    private String pavimentacao;

	    @Enumerated(EnumType.STRING)
	    private SimNao iluminacaoPublica;

	    @NotBlank
	    private String equipamentosUrbanos;

	    @NotNull
	    @Enumerated(EnumType.STRING)
	    private EsporteLazer espacosEsporteLazer;

	    @NotBlank
	    private String programaInfraSaneamento;

	    @NotNull
	    private EntrevistadoIdInput entrevistado;
	

}
