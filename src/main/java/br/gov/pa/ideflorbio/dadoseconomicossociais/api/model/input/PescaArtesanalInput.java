package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.ConservacaoTipo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoPescariaCusteio;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PescaArtesanalInput {

   
	
    private double horasPorDia = 0;
	
	
    private String localDaPesca = "Não informado";
    private String horarioPrefencialPesca = "Não informado";
    private float descartePorPescaria = 0;
    private Set<ConservacaoTipo> conservacaoPeixenew = new HashSet<>(Arrays.asList(ConservacaoTipo.Nenhum));
    private Set<TipoPescariaCusteio> custeio = new HashSet<>(Arrays.asList(TipoPescariaCusteio.NAO_DECLARADO));;
    private double geloPorPescaria=0;
    private double custoGeloPorPescaria=0;
    private String composicaoRancho= "Não informado";
    private double custoRanchoPorViagem = 0;
    private double combustivelPorViagem = 0;
    private double custoCombustivelPorViagem = 0;
    private String localDesembarque= "Não informado";
    
    @NotNull
	@Enumerated(EnumType.STRING)
    private ConservacaoTipo conservacaoTipo;
    
    
    private double pescaPorSafra = 0;
    
    
    private String localPescaSafra= "Não informado";
    private String localDeReproducaoPeixe= "Não informado";
    private String periodoDefeso= "Não informado";
    
    @NotNull
	@Enumerated(EnumType.STRING)
    private SimNaoTalvez conheceDefeso;
    
    @NotNull
	@Enumerated(EnumType.STRING)
    private SimNaoTalvez concordaDefeso;
    
    @NotNull
	@Enumerated(EnumType.STRING)
    private SimNaoTalvez recebeDefeso;
    
    @NotNull
	private BenfeitoriaIdInput benfeitoria;

  
}
