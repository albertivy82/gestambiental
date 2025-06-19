package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class QuantidadePescaPorTipoNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public QuantidadePescaPorTipoNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public QuantidadePescaPorTipoNaoEncontradaException(Long id) {
		this("Os dados sobre a destinação da pesca de código %d não existe".formatted(id));
	}

	
}
