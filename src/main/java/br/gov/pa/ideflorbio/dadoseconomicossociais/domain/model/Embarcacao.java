package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBarco;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCasco;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Embarcacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	private String numeracao;
    
	@Enumerated(EnumType.STRING)
    private TipoBarco tipoBarco;
    
	@Enumerated(EnumType.STRING)
    private TipoCasco tipoCasco;
	
	@ManyToOne
	@JoinColumn(name="pescaArtesanal")
    private PescaArtesanal pescaArtesanal;

}
