package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class PeixesException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public PeixesException(String message) {
		super(message);
		
	}
	
	public PeixesException(Long id) {
		this("Os dados sobre peixes de código %d não existe".formatted(id));
	}

	
}
