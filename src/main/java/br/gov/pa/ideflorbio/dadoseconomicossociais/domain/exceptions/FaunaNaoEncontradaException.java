package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class FaunaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public FaunaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public FaunaNaoEncontradaException(Long id) {
		this("Os dados de fauna cadastrados com código %d não existem".formatted(id));
	}

	
}
