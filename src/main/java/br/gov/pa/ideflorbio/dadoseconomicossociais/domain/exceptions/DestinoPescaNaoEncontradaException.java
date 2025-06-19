package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class DestinoPescaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public DestinoPescaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public DestinoPescaNaoEncontradaException(Long id) {
		this("Os dados sobre a destinação da pesca de código %d não existe".formatted(id));
	}

	
}
