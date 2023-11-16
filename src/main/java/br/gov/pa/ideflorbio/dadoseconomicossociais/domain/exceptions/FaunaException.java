package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class FaunaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public FaunaException(String message) {
		super(message);
		
	}
	
	public FaunaException(Long id) {
		this("Os dados de fauna cadastrados com código %d não existem".formatted(id));
	}

	
}
