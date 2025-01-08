package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Documentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EsporteLazer;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.LimitesTerreno;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSolo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Transporte;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Vizinhos;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ImovelInput {
	
	private String rua;
	
    private String numero;
    
    private String bairro;
    
    @NotBlank
    private String referencial;
    
    @NotBlank
    private String latitude;
    
    @NotBlank
    private String longitude;

	@NotNull
	private double areaImovel;
    
    @Enumerated(EnumType.STRING)
    private Vizinhos vizinhos;
    
    @Enumerated(EnumType.STRING)
    private Situacao_Fundiaria situacaoFundiaria;
    
    @Enumerated(EnumType.STRING)
    private Documentacao documentacaoImovel;
    
    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date dataChegada;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private SimNaoTalvez pretendeMudar;
    
    private String MotivoVontadeMudanca;
    
    @NotBlank
    private String relacaoArea;
    
    @NotBlank
    private String relacaoVizinhos;
    
    @Enumerated(EnumType.STRING)
    private LimitesTerreno limites;
    
    @Enumerated(EnumType.STRING)
    private SimNaoTalvez iluminacaoPublica;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Transporte transporte;
    
    @NotBlank
	private String programaInfraSaneamento;
    
    @NotBlank
    private String linhasDeBarco;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoSolo tipoSolo;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private EsporteLazer esporteLazer;
    
    @NotNull
    private EntrevistadoIdInput entrevistado;
	

}
