package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordenadaDTO {
	
		
	private Long id;
		
    private String latitude;
    
    private String longitude;
    
    private LocalidadeIdDTO localidade;
    
    
    @Override
    public String toString() {
        return "CoordenadaDTO{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", localidadeId=" + localidade +
                '}';
    }

		
		
}
