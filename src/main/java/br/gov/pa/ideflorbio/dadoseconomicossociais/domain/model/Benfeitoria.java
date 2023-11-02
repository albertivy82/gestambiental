package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Efluentes;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EnergiaAlimentos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.FonteEnergia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Funcao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.InformativoPredominante;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.MetodoTratamentoAgua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.QualidadeAgua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Residuos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBenfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCobertura;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoConstrucao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoEsquadrias;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSoloBenfeitoria;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
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
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private int paviementos;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoConstrucao tipoConstrucao;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoCobertura tipoCobertura;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoEsquadrias tipoEsquadrias;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private MetodoTratamentoAgua tratamentoAgua;
	

	@NotBlank
	@Enumerated(EnumType.STRING)
	private QualidadeAgua qualidadeAgua;
	

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
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<DadosDeConsumo> consumo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "benfeitoria")
	private ServicosBasicos servicosBasicos;
	
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




}
