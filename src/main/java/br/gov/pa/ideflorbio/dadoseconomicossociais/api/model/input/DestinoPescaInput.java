package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNaoTalvez;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinoPescaInput {

	private String finalidade;
	
	private double quantidade;
	
	
	private String destino;
	
	@Enumerated(EnumType.STRING)
	private SimNaoTalvez destinoFixo;
	
	private int paraQuantos;	
	
	@NotBlank
    private PescaArtesanalIdInput pescaArtesanal;
	
}

