package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;


import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.TipoPescaArtesanal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantidadePescaPorTipoDTO {

    private Long id;
    private double quantidadePesca;
    private TipoPescaArtesanal tipoPesca;
    private Long pescaArtesanalId; 
}

