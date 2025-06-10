package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Funcao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBenfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCobertura;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoConstrucao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoEsquadrias;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoSoloBenfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Transporte;
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
	

    @NotNull
    private ImovelIdInput imovel;

}
