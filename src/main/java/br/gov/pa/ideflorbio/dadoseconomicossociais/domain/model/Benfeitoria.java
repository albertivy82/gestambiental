package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Efluentes;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EnergiaAlimentos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.FonteEnergia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Funcao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.InformativoPredominante;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.NivelAlagamento;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Ocorrencia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.OrigemMaterialConstrucao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Residuos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBenfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCobertura;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoConstrucao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoEsquadrias;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSoloBenfeitoria;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Benfeitoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoBenfeitoria tipoBenfeitoria;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Funcao funcao;

	@NotBlank
	@Enumerated(EnumType.STRING)	
	private TipoSoloBenfeitoria tipoSolo;
	
	@NotNull
	private double areabenfeitoria;
	

	@NotNull
	private int paviementos;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoConstrucao tipoConstrucao;
	
	
	@ElementCollection(targetClass = OrigemMaterialConstrucao.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "benfeitoria_material_construcao")
	@Column(name = "origem_material_construcao")
	private Set<OrigemMaterialConstrucao> OrigemMaterialConstrucao = new HashSet<>();
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoCobertura tipoCobertura;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoEsquadrias tipoEsquadrias;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Ocorrencia alagamentos;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private NivelAlagamento nivelAlagamentos;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Efluentes efluentes;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Residuos residuos;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private FonteEnergia fonteEnergia;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private EnergiaAlimentos energiaAlimentos;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private InformativoPredominante informativoPredominante;
	
	private String importanciaDeProtegerFauna;
	
	private String importanciaDeProtegerAmibiente;
	
	private String qualEspacoPrecisaSerPreservado;
	
	private String probelmasRelacionadosAoAmbiente;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<DadosDeConsumo> consumo;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Dependencias> dependencia;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<ServicosComunicacao> servicosComunicacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Vegetacao> etnoVegetacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Fauna> etnoFauna;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Peixes> etnoPeixe;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Repteis> etnoRepteis;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Mamiferos> etnoMamiferos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Aves> etnoAves;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "benfeitoria")
	private Agua agua;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Violencia> violenciaSofrida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<InstituicaoConhecida> instituicaoConhecida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<AtividadeProdutiva> atividadeProdutiva;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<RendaOutrasFontes> rendaOutrasFontes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Credito> credito;
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private  List<Morador> morador;
	
	@JsonIgnore
	@OneToOne(mappedBy = "benfeitoria")
	private PescaArtesanal pescaArtesanal;




}
