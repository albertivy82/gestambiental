package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.HashSet;
import java.util.Set;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Servico;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OutrosServicos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
	private Servico outrosServicos;
	
	@ManyToMany(mappedBy = 	"outrosServicos")
	private Set<Imovel> imoveis = new HashSet<>();

}
