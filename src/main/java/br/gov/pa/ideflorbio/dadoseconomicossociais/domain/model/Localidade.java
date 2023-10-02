package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Esfera;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Municipio;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Localidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Municipio municipio;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Esfera esfera;
	
	@JsonIgnore
	@OneToMany(mappedBy = "localidade")
	private List<Coordenada> coordenadas;
	
	@JsonIgnore
	@OneToOne(mappedBy = "localidade")
	private PostoDeSaude postoDeSaude;
	
	@JsonIgnore
	@OneToMany(mappedBy="localidade")
	private List<Escola> escolas;
	
	@JsonIgnore
	@OneToMany(mappedBy="localidade")
	private List<Imovel> imovel;
	
	
}
