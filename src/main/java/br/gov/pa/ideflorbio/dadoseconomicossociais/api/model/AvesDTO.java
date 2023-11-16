package br.gov.pa.ideflorbio.dadoseconomicossociais.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvesDTO {
	
	private Long id;
	
	
	private String possuiForneceimentoPublico;
		
	private String qualidadeFornecimentoPublico;
	
	private String corAguaForncimentoPublico;
	
	public String saborAguaFornecimentoPublico;


	public String cheiroAguaFornecimentoPublico;
	
	private String poco;
	
	private double profundidadePoco;
	
	private String corAguaPoco;
	
	public String saborAguaPoco;
	
	public String cheiroAguaPoco;
	
	private String tratamentoAgua;
	
	private BenfeitoriaIdDTO benfeitoria; 
		
}
