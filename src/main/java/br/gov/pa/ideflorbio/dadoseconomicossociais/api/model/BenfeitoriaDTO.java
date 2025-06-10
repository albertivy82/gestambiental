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
	    
	    private String afastamentoDaPrincipal;
	    
	    private String impermeabilizacaoSolo;
	    
	    private String limites;
	    
	    private double areaBenfeitoria;
	    
	    private int pavimentos;
	    
	    private String paredes;
	    
	    private String tipoCobertura;
	    
	    private String tipoEsquadrias;
	    
	    private String origemMadeiraDaConstrucao;
	    
	    private String origemPedraDaConstrucao;
	    
	    private String origemAreiaDaConstrucao;
	    
	    private String alagamentos;

	    private String epocaOcorrencia;

	    private String efluentes;
	        
	    private String residuos;
	    
	    private String fonteEnergia;
	        
	    private String energiaAlimentos;
	    
	    private String meiosLocomocao;
	    
	    private String linhasOnibus;
	        
	    private String informativoPredominante;

	    private List<DependenciasDTO> dependencia;

	    private List<MoradorDTO> morador;
	    
	    private List<AtividadeProdutivaDTO> atividadeProdutiva;

	    private List<ServicosComunicacaoDTO> servicosComunicacao;
	    
	    private AguaDTO agua;
	    
	    private List<RendaOutrasFontesDTO> rendaOutrasFontes;

	    private List<CreditoDTO> credito;

	    private PescaArtesanalDTO pescaArtesanal;

	    private ImovelIdDTO imovel;
	

}
