package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Funcao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBenfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCobertura;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoConstrucao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoEsquadrias;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSoloBenfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Transporte;
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
	
	
	private String afastamentoDaPrincipal;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoSoloBenfeitoria impermeabilizacaoSolo;
	
	
	private String limites;

	
	
	@NotNull
	private double areaBenfeitoria;
	

	@NotNull
	private int pavimentos;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoConstrucao paredes;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoCobertura tipoCobertura;
	

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEsquadrias tipoEsquadrias;
	
	@NotNull
	private String origemMadeiraDaConstrucao;
	@NotNull
	private String origemPedraDaConstrucao;
	@NotNull
	private String origemAreiaDaConstrucao;
	
	@NotNull
    private String alagamentos;

    @NotNull
    private String epocaOcorrencia;

    @NotNull
	private String efluentes;
	
    @NotNull
	private String residuos;
	
    @NotNull
	private String fonteEnergia;
		
    @NotNull
	private String energiaAlimentos;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Transporte meiosLocomocao;
	
	@NotNull
	private String linhasOnibus;
	
	@NotNull
	private String informativoPredominante;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private  List<Morador> morador;

	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<AtividadeProdutiva> atividadeProdutiva;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<ServicosComunicacao> servicosComunicacao;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "benfeitoria")
	private Agua agua;
	

	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<RendaOutrasFontes> rendaOutrasFontes;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Credito> credito;
	
		
	@JsonIgnore
	@OneToOne(mappedBy = "benfeitoria")
	private PescaArtesanal pescaArtesanal;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;


}
