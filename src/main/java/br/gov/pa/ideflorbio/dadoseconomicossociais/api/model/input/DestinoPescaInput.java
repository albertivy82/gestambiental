package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.DestinacaoPesca;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.DestinoPescado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinoPescaInput {

	@NotBlank
	@Enumerated(EnumType.STRING)
    private DestinacaoPesca destinacao;
	
	@NotNull
	private double quantidade;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
    private DestinoPescado destino;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
    private SimNaoTalvez destinoFixo;
	
	@NotNull
    private int paraQuantos;
	
	@NotBlank
    private PescaArtesanalIdInput pescaArtesanal;
	
}

