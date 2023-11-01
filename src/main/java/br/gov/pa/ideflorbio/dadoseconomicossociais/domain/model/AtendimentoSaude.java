package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.atendimentoSaude;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AtendimentoSaude implements Serializable{

		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private atendimentoSaude tipoAtendimento;
	

	@ManyToMany(mappedBy = 	"atendimentoSaude")
	private Set<Imovel> imoveis = new HashSet<>();
	
}
