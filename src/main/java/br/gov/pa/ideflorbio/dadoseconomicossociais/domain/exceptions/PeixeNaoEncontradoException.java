package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class PeixeNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public PeixeNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public PeixeNaoEncontradoException(Long id) {
		this("Os dados sobre peixes de código %d não existe".formatted(id));
	}

	
}
