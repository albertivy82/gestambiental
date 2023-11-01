package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.sql.Date;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Escolaridade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EstadoCivil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Perfil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Sexo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MoradorInput {
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataNascimento;
	
	@NotNull
	private int idade;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
	private String ondeEstuda;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez trabalho;
	
	@NotBlank
	private String religiao;
	
	private ImovelIdInput residencia;


}
