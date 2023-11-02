package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.HashSet;
import java.util.Set;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.Embarcacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.ConservacaoTipo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PescaArtesanal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	private int freqPescaSemanal;
    
    private double horasPorDia;
    
    private String localDaPesca;
    
    private String horarioPrefencialPesca;
    
    private float descartePorPescaria;
    
    private double geloPorPescaria;
    
    private double custoGeloPorPescaria;
    
    private String composicaoRancho;
    
    private double custoRanchoPorViagem;
    
    private double combustivelPorViagem;
    
    private double custoCombustivelPorViagem;
    
    private String localDesembarque;
    
   private ConservacaoTipo conservacaoTipo;
    
   @OneToMany
   private Set<DestinoPesca> destinopesca = new HashSet<>();
    
    private double pescaPorSafra;
    private String localPescaSafra;
    private String localDeReproducaoPeixe;
    private String periodoDefeso; 
    private SimNaoTalvez conheceDefeso;
    private SimNaoTalvez concordaDefeso;
    private SimNaoTalvez recebeDefeso;
    
    private QuantidadePescaPorTipo quantidadePescaPorTipo;
    
    private Embarcacao embarcacao;
    
    private Especie especies;
    
    @ManyToOne
	@JoinColumn(name="benfeitoria")
	private Benfeitoria benfeitoria;
    
    
    
    
    
    
    
}

