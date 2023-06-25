package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.ServicoPublicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.atendimentoSaude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//F-> SERVIÇOS PÍBLICOS
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ServicosBasicos implements Serializable{

		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private atendimentoSaude tipoAtendimento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ServicoPublicos servicosDeficitarios;
		
	
	@NotNull
	@OneToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;
	
}
