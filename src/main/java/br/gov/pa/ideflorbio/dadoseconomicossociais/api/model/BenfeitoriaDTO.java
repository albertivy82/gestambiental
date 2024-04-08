package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BenfeitoriaDTO {
	
	private Long id;
	
    private String tipoBenfeitoria;
	
	private String funcao;

	private String tipoSolo;
	
	private double areaBenfeitoria;
	
	private int pavimentos;
	
	private String tipoConstrucao;
	
	private List<String> origemMaterialConstrucao;
	
	private String tipoCobertura;
	
	private String tipoEsquadrias;
	
	private String alagamentos;
	
	private String nivelAlagamentos;

	private String efluentes;
		
	private String residuos;
	
	private String fonteEnergia;
		
	private String energiaAlimentos;
		
	private String informativoPredominante;
	
	private String importanciaDeProtegerFauna;
	
	private String importanciaDeProtegerAmbiente;
	
	private String qualEspacoPrecisaSerPreservado;
	
	private String problemasRelacionadosAoAmbiente;
	
	private ImovelIdDTO imovel;
	

}
