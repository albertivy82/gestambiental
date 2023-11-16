package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class DestinoPescaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public DestinoPescaException(String message) {
		super(message);
		
	}
	
	public DestinoPescaException(Long id) {
		this("Os dados sobre a destinação da pesca de código %d não existe".formatted(id));
	}

	
}
