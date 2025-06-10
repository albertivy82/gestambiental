package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Escolaridade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EstadoCivil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Perfil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Morador implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	
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
	
	@NotBlank
	private String trabalho;
	
	@NotBlank
	private String religiao;
	
	@NotBlank
	private String doencas;
	//ver arquivo moléstias
	
	@OneToMany(mappedBy = "morador")
	private List<ParticipacaoInstituicao> participacaoInstituicao;
	
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
