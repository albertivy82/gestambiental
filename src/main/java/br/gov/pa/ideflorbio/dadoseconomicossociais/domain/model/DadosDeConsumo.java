package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Alimentacao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// IV SAÚDE, C E D
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class DadosDeConsumo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
	private Alimentacao alimentacaoPrincipal;
	
	private String LocalDeCompras;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
