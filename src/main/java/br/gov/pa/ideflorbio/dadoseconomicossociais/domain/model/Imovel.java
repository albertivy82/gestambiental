package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Documentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class Imovel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	private String rua;
	
	private String numero;
	
	private String bairro;
	
	@NotBlank
	private String referencial;
	
	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;
	
	@Enumerated(EnumType.STRING)
	private Situacao_Fundiaria situacaoFundiaria;
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataChegada;
	
	
	//@Enumerated(EnumType.STRING)
	//private LimitesImovel limites;
	
	
	@Enumerated(EnumType.STRING)
	private Documentacao documentacaoImovel;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao pretendeMudar;

	private String MotivoVontadeMudanca;
	
	@NotBlank
	private String relacaoArea;
	
	@NotBlank
	private String relacaoVizinhos;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="localidade")
	private Localidade localidade;
	
	@JsonIgnore
	@OneToOne(mappedBy="imovel")
	private Entrevistado entrevistado;
	
	@JsonIgnore
	@OneToOne(mappedBy = "imovel")
	private DadosDeConsumo consumo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "imovel")
	private ServicosBasicos servicosBasicos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<Violencia> violenciaSofrida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<InstituicaoConhecida> instituicaoConhecida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<AtividadeProdutiva> atividadeProdutiva;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<RendaOutrasFontes> rendaOutrasFontes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<Credito> credito;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private  List<Morador> morador;
	
}
