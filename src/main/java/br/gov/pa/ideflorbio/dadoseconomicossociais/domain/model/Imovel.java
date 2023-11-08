package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Documentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EsporteLazer;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.LimitesTerreno;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSolo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Transporte;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Vizinhos;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Imovel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String rua;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String referencial;
	
	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;
	
	@NotNull
	private double areaImovel;
	
	
	@Enumerated(EnumType.STRING)
	private Vizinhos vizinhos;
	
	
	@Enumerated(EnumType.STRING)
	private Situacao_Fundiaria situacaoFundiaria;
	
	@Enumerated(EnumType.STRING)
	private Documentacao documentacaoImovel;
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataChegada;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez pretendeMudar;

	private String MotivoVontadeMudanca;
	
	@NotBlank
	private String relacaoArea;
	
	@NotBlank
	private String relacaoVizinhos;
	
	@Enumerated(EnumType.STRING)
    private LimitesTerreno limites;
	
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez iluminacaoPublica;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Transporte transporte;
	
	@NotBlank
	private String programaInfraSaneamento;
	
	@NotBlank
	private String linhasDeBarco;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoSolo tipoSolo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EsporteLazer esporteLazer;
	
	@JsonIgnore
	@OneToOne(mappedBy="imovel")
	private Entrevistado entrevistado;
	
		
	@NotNull
	@ManyToOne
	@JoinColumn(name="localidade")
	private Localidade localidade;
	
	@ManyToMany
    @JoinTable(
        name = "imovel_servicos_basicos",
        joinColumns = @JoinColumn(name = "imovel"),
        inverseJoinColumns = @JoinColumn(name = "servicos_basicos")
    )	
	private Set<ServicosBasicos> servicosBasicos = new HashSet<>();
	
	@ManyToMany
    @JoinTable(
        name = "imovel_atendimento_saude",
        joinColumns = @JoinColumn(name = "imovel"),
        inverseJoinColumns = @JoinColumn(name = "atendimento_saude")
    )
	private Set<AtendimentoSaude> atendimentoSaude = new HashSet<>();
	
	@ManyToMany
    @JoinTable(
        name = "imovel_outros_servicos",
        joinColumns = @JoinColumn(name = "imovel"),
        inverseJoinColumns = @JoinColumn(name = "outros_servicos")
    )
	private Set<OutrosServicos> outrosServicos = new HashSet<>();
		
}
