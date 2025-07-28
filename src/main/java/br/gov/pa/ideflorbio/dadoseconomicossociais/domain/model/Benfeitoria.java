package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String tipoBenfeitoria;
	 //Residencia,
	 //Vareneio,
	 //Comercio,
	 //SemUso,
	 //Nao_Informado,
	 //Outro

	@NotNull
	private String funcao;
	 //Principal,
	 //Secundaria
	
	
	private String afastamentoDaPrincipal;
	
	
	@NotNull
	private String impermeabilizacaoSolo;
	 //Terreno_Natural,
	 //Vejetacao,
	 //Cimentado,
	// Outro

	
	private String limites;

	
	@NotNull
	private double areaBenfeitoria;
	

	@NotNull
	private int pavimentos;
	
	
	@NotNull
	private String paredes;
	//Alvenaria,
    //Madeira,
    //Taipa,
    //Palha,
    //Outro

	@NotNull
	private String tipoCobertura;
	//Telha_de_Barro,
    //Brasilit,
    //Palha,
    //Laje,
    //Outros

	@NotNull
	private String tipoEsquadrias;
	//madeira,
	//aluminio,
	//PVC,
	//vidro
	
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
	 //CARRO("Carro"),
	 //BARCO("Barco"),
	 //BICICLETA("Bicicleta"),
	 //A_PÉ("Deslocamento a pé"),
	// MOTO("Motocicleta"),
	 //RABETA("Rabeta"),
	 //OUTRO("Outros");
	
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
	@OneToMany(mappedBy = "benfeitoria")
	private List<RendaOutrasFontes> rendaOutrasFontes;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "benfeitoria")
	private List<Credito> credito;
	
		
		
	@NotNull
	@ManyToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;


}
