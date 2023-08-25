package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Municipio;
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
	
	@ManyToMany
	@JoinTable(
	        name="localidade_usuario",
	        joinColumns=@JoinColumn(name="localidade"),
	        inverseJoinColumns=@JoinColumn(name="usuario")
	    )
	private Set<Usuario> usuario = new HashSet<>();
	

}
