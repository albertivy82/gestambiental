package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.sql.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
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
	
	
	@Enumerated(EnumType.STRING)
	private Situacao_Fundiaria situacao_Fundiaria;
	
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataChegada;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao pretendeMudar;
	

	private String MotivoVontadeMudança;
	
	@NotBlank
	private String relacaoArea;
	
	@NotBlank
	private String relacaoVizinhos;
	
	
	@NotNull
	private LocalidadeIdInput localidade;
	

}
