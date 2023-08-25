package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class CoordenadaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public CoordenadaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public CoordenadaNaoEncontradaException(Long id) {
		this("A coordenada de código %d não existe".formatted(id));
	}

	
}
