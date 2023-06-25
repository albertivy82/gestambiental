package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class LocalidadeNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public LocalidadeNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public LocalidadeNaoEncontradaException(Long id) {
		this("A localidade de código %d não existe".formatted(id));
	}

	
}
