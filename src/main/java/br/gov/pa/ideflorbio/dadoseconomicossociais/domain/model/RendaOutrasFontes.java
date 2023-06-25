package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PositiveOrZero;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.FontesRenda;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


//b-> QUAIS OUTRAS FONTES DE RENDA FAMILIAR
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RendaOutrasFontes implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
	private FontesRenda fonte;
	
	
	private int beneficiarios;
	
	
	@PositiveOrZero(message = "informe um valor válido")
	private BigDecimal rendaMesTotal;
	
	
	@ManyToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;
}
