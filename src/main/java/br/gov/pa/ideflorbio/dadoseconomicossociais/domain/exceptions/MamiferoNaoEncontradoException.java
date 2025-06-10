package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class MamiferoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public MamiferoNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public MamiferoNaoEncontradoException(Long id) {
		this("Os dados sobre mamíferos de código %d não existe".formatted(id));
	}

	
}
