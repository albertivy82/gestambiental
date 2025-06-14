package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class PescaArtesanalNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public PescaArtesanalNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public PescaArtesanalNaoEncontradaException(Long id) {
		this("Os dados relativos a pesca artesanal de código %d não existe".formatted(id));
	}

	
}
