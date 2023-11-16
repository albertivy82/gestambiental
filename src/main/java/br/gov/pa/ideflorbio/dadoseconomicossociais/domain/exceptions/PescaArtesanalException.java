package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class PescaArtesanalException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public PescaArtesanalException(String message) {
		super(message);
		
	}
	
	public PescaArtesanalException(Long id) {
		this("Os dados relativos a pesca artesanal de código %d não existe".formatted(id));
	}

	
}
