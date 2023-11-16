package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class VegetacaoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public VegetacaoException(String message) {
		super(message);
		
	}
	
	public VegetacaoException(Long id) {
		this("Os dados sobre vegetacao de código %d não existem".formatted(id));
	}

	
}
