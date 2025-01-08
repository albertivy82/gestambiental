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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoBenfeitoria tipoBenfeitoria;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private Funcao funcao;

	@NotNull
	@Enumerated(EnumType.STRING)	
	private TipoSoloBenfeitoria tipoSolo;
	
	@NotNull
	private double areaBenfeitoria;
	

	@NotNull
	private int pavimentos;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoConstrucao tipoConstrucao;
	
	
	@ElementCollection(targetClass = OrigemMaterialConstrucao.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "benfeitoria_material_construcao")
	@Column(name = "origem_material_construcao")
	private Set<OrigemMaterialConstrucao> origemMaterialConstrucao = new HashSet<>();
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoCobertura tipoCobertura;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEsquadrias tipoEsquadrias;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Ocorrencia alagamentos;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private NivelAlagamento nivelAlagamentos;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Efluentes efluentes;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private Residuos residuos;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private FonteEnergia fonteEnergia;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private EnergiaAlimentos energiaAlimentos;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private InformativoPredominante informativoPredominante;
	
	private String importanciaDeProtegerFauna;
	
	private String importanciaDeProtegerAmbiente;
	
	private String qualEspacoPrecisaSerPreservado;
	
	private String problemasRelacionadosAoAmbiente;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "benfeitoria")
	private Compras compras;
	
	
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
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;


}
