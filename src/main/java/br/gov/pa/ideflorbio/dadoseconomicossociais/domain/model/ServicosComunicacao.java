package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Operadora;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoServicComunicacao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServicosComunicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoServicComunicacao tipoServicoComunicacao;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Operadora operadoraServicoComunicacao;
	
	
	@NotBlank
    @ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;

}
