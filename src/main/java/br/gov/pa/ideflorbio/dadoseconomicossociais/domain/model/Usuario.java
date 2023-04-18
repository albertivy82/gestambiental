package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String matricula;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String senha;
	
	@JsonIgnore
	@ManyToMany(mappedBy="usuario")
	private List<Localidade> localidade;
	
	@ManyToMany
	@JoinTable(
			name="usuario_grupo",
			joinColumns = @JoinColumn(name="usuario"),
			inverseJoinColumns = @JoinColumn(name ="grupo")
	)
	private Set<Grupo> grupo = new HashSet<>();
	
	
	public boolean isNovo() {
		return getId() == null;
	}

}
