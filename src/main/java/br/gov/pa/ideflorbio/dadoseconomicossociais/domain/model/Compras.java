package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.LocalCompras;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// IV SAÚDE, C E D
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Compras implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private LocalCompras ondeFazCompras;
	
	
	private String detalheLocalDeCompras;
	
	
	@OneToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
