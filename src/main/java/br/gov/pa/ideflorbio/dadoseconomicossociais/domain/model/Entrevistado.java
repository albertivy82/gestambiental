package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Escolaridade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.EstadoCivil;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Sexo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Entrevistado implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	
	private String naturalidade;
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date nascimentoData;
	
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	private String apelido;
	
	
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
	
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	private String religiao;
	
	@Enumerated(EnumType.STRING)
	private SimNao morador;
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataChegada;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez pretendeMudar;
	
	private String motivoVontadeMudanca;

	
	@NotBlank
	private String relacaoAreaImovel;
	
	@NotBlank
	private String relacaoVizinhos;
	
	@NotBlank
	private String tipoAlimentacao;
	
	@NotBlank
	private String localCompras;
	
	private String comoCuidaSaudeFamilia;
	
	@NotBlank
	private String servicosDeficitarios;
	
	@NotNull
	private Integer sofreuAssaltos;

	@NotNull
	private Integer presenciouAssalto;

	@NotBlank
	private String problemasDeViolenciaLocal;

	
	private String instituicaoConhecida;
	
	
	@Enumerated(EnumType.STRING)
	private SimNao conheceUcs;
	
	@Enumerated(EnumType.STRING)
	private SimNao conheceUcProposta;
	
	
	@Enumerated(EnumType.STRING)
	private SimNao conheceAreaUc;
	

    private String importanciaDeProtegerAmbiente;
    
    private String importanciaDeProtegerFauna;
	
	private String qualEspacoPrecisaSerPreservado;
	
	private String problemasRelacionadosAoAmbiente;
	
	private String utilizaAreaUc;
	
	private String propostaMelhorarArea;
	
	private String indicadoConsultaPublica;
	
	private String contatoIndicadoConsultaPublica;
	
	

	@JsonIgnore
	@OneToMany(mappedBy = "entrevistado")
	private List<Vegetacao> etnoVegetacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entrevistado")
	private List<Fauna> etnoFauna;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "entrevistado")
	private List<Peixes> etnoPeixe;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entrevistado")
	private List<Repteis> etnoRepteis;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entrevistado")
	private List<Mamiferos> etnoMamiferos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entrevistado")
	private List<Aves> etnoAves;
	
			
	@NotNull
	@ManyToOne
	@JoinColumn(name="localidade")
	private Localidade localidade;
	
	
	

}
