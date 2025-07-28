package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank
	private String perfil;
	
	private int dataNascimento;
	
	@NotBlank
	private String sexo;
	
	@NotBlank
	private String escolaridade;
	
	@NotBlank
	private String estadoCivil;
	
	@NotBlank
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
