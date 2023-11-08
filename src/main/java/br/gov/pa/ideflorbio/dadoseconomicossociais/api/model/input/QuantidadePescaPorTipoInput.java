package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoPescaArtesanal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantidadePescaPorTipoInput {

    private double quantidadePesca;
    private TipoPescaArtesanal tipoPesca;
    private Long pescaArtesanalId; 
}

