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
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank
	private String tipoBenfeitoria;
	 //Residencia,
	 //Vareneio,
	 //Comercio,
	 //SemUso,
	 //Nao_Informado,
	 //Outro

	@NotBlank
	private String funcao;
	 //Principal,
	 //Secundaria
	
	
	private String afastamentoDaPrincipal;
	
	
	@NotBlank
	private String impermeabilizacaoSolo;
	 //Terreno_Natural,
	 //Vejetacao,
	 //Cimentado,
	// Outro

	
	@NotBlank
	private String limites;

	
	
	private double areaBenfeitoria;
	

	
	private int pavimentos;
	
	
	@NotBlank
	private String paredes;
	//Alvenaria,
    //Madeira,
    //Taipa,
    //Palha,
    //Outro

	@NotBlank
	private String tipoCobertura;
	//Telha_de_Barro,
    //Brasilit,
    //Palha,
    //Laje,
    //Outros

	@NotBlank
	private String tipoEsquadrias;
	//madeira,
	//aluminio,
	//PVC,
	//vidro
	
	@NotBlank
	private String origemMadeiraDaConstrucao;
	@NotBlank
	private String origemPedraDaConstrucao;
	@NotBlank
	private String origemAreiaDaConstrucao;
	
	@NotBlank
    private String alagamentos;

	
    private String epocaOcorrencia;

	@NotBlank
	private String efluentes;
	
    @NotBlank
	private String residuos;
	
    @NotBlank
	private String fonteEnergia;
		
    @NotBlank
	private String energiaAlimentos;
	
	
    @NotBlank
	private String meiosLocomocao;
	 //CARRO("Carro"),
	 //BARCO("Barco"),
	 //BICICLETA("Bicicleta"),
	 //A_PÉ("Deslocamento a pé"),
	// MOTO("Motocicleta"),
	 //RABETA("Rabeta"),
	 //OUTRO("Outros");
	
    @NotBlank
	private String linhasOnibus;
	
    @NotBlank
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
