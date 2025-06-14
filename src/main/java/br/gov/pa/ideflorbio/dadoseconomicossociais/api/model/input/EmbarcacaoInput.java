package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoBarco;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoCasco;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmbarcacaoInput {

private String numeracao;
    
	@Enumerated(EnumType.STRING)
    private TipoBarco tipoBarco;
    
	@Enumerated(EnumType.STRING)
    private TipoCasco tipoCasco;
	
    private PescaArtesanalIdInput pescaArtesanal; 
}