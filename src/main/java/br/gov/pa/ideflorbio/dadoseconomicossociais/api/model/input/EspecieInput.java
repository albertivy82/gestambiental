package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Exploracao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TamanhoPesca;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecieInput {

	@NotBlank
    private String especie;
    
    @NotBlank
    private double quantidadePescada;
    
    @Enumerated(EnumType.STRING)
    private TamanhoPesca tamanhoDaPesca;
    
    @Enumerated(EnumType.STRING)
    private Exploracao exploracaoNivel;
    
    @NotBlank
    private double precoVendaMedioKg;
    
    @NotBlank
    private String importancia;
    
    @NotBlank
    private String mesesMaiorOcorrencia;
	@NotBlank
    private PescaArtesanalIdInput pescaArtesanal; 
}
