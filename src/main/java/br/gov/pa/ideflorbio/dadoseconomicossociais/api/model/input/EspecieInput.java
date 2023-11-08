package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Exploracao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TamanhoPesca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecieInput {

	@NotBlank
    private String especie = "Não informado";
	@NotNull
	private double quantidadePescada = 0;
	@NotBlank
    private TamanhoPesca quantidadeDaPesca = TamanhoPesca.NAO_DECLARADO;
	@NotBlank
    private TamanhoPesca tamanhoDaPesca = TamanhoPesca.NAO_DECLARADO;
	@NotBlank
    private Exploracao exploracaoNivel = Exploracao.NAO_INFORMADO;
	@NotBlank
    private double precoVendaMedioKg = 0;
	@NotBlank
    private String importancia  ="não informado";
	@NotBlank
    private String mesesMaiorOcorrencia ="não informado";
	@NotBlank
    private PescaArtesanalIdInput pescaArtesanal; 
}
