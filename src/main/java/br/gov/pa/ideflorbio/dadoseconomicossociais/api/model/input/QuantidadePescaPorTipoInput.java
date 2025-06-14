package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantidadePescaPorTipoInput {

   private String tipoPesca;
   private double quantidadePesca;
	
   @NotBlank
    private PescaArtesanalIdInput pescaArtesanal; 
}
