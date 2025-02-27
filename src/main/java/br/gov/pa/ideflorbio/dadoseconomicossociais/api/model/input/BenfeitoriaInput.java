package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.util.HashSet;
import java.util.Set;

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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BenfeitoriaInput {
	
	
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
	
	
	@NotNull
	private ImovelIdInput imovel;

}
