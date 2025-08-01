package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ImovelInput {
	    
	
		@NotBlank
		private String rua;
		
		@NotBlank
		private String numero;
		
		@NotBlank
		private String bairro;
		
		@NotBlank
		private String referencial;
		
		@NotBlank
		private String latitude;
		
		@NotBlank
		private String longitude;
		
		@NotNull
		private double areaImovel;
		
		@NotBlank
		private String tipoSolo;
		
		@NotBlank
		private String vizinhosConfinantes;
		
		
		@NotBlank
		private String situacaoFundiaria;
		
		@NotBlank
		private String documentacaoImovel;
		
	
		@NotBlank
	    private String limites;
		
			
		@NotBlank
		private String linhasDeBarco;
		
		@NotBlank
		private String pavimentacao;
		
		
		@Enumerated(EnumType.STRING)
		private SimNao iluminacaoPublica;
		
		@NotBlank
		private String equipamentosUrbanos;
		
		@NotBlank
		private String espacosEsporteLazer;
		
		@NotBlank
		private String programaInfraSaneamento;

	    @NotNull
	    private EntrevistadoIdInput entrevistado;
	

}
