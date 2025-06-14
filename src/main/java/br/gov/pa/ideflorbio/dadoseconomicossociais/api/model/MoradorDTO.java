package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ParticipacaoInstituicao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Escolaridade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EstadoCivil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Perfil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoradorDTO {
	
	
	
	private String perfil;
	
	
	private Date dataNascimento;
	
	
	private int idade;
	
	
	private String sexo;
	
	
	private String escolaridade;
	
	
	private String estadoCivil;
	
	private String ondeEstuda;
	
	
	private String trabalho;
	
	
	private String religiao;
	

	private String doencas;
	
	private BenfeitoriaIdDTO benfeitoria;
	
	

}
