package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BenfeitoriaInput {
	
	
	@NotNull
    private String tipoBenfeitoria;

    @NotNull
    private String funcao;

    private String afastamentoDaPrincipal;

    @NotNull
    private String impermeabilizacaoSolo;

    private String limites;

    @NotNull
    private double areaBenfeitoria;

    @NotNull
    private int pavimentos;

    @NotNull
    private String paredes;

    @NotNull
    private String tipoCobertura;

    @NotNull
    private String tipoEsquadrias;

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
	private String meiosLocomocao;
	
	@NotNull
	private String linhasOnibus;
	
	@NotNull
	private String informativoPredominante;
	

    @NotNull
    private ImovelIdInput imovel;

}
