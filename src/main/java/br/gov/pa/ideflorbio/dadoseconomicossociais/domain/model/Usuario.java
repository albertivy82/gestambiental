package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


//ENTREVISTADOR
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
	
	
	@ManyToMany
	@JoinTable(
			name="usuario_grupo",
			joinColumns = @JoinColumn(name="usuario"),
			inverseJoinColumns = @JoinColumn(name ="grupo")
	)
	private Set<Grupo> grupo = new HashSet<>();
	
	
	
	
	

}
