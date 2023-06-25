package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

//G->SEGURANÇA PÚBLICA

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Condicao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.ViolenciaTipo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Violencia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ViolenciaTipo tipo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Condicao condicao;
	
	@NotNull
	private int ocorrencias;
	
	
	private String destaqueDoMorador;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;

}
