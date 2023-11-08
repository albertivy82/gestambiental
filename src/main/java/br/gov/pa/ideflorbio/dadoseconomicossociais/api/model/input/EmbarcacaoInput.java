package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBarco;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCasco;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmbarcacaoInput {

	@NotBlank
    private String numeracao  ="Não Informado";
	@NotBlank
    private TipoBarco tipoBarco = TipoBarco.NAO_INFORMADO;
	@NotBlank
    private TipoCasco tipoCasco = TipoCasco.Nada_consta;
	
    private PescaArtesanalIdInput pescaArtesanal; 
}