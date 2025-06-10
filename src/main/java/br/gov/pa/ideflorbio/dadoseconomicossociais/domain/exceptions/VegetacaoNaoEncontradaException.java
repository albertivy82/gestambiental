package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class VegetacaoNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public VegetacaoNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public VegetacaoNaoEncontradaException(Long id) {
		this("Os dados sobre vegetacao de código %d não existem".formatted(id));
	}

	
}
