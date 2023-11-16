package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class MamiferosException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public MamiferosException(String message) {
		super(message);
		
	}
	
	public MamiferosException(Long id) {
		this("Os dados sobre mamíferos de código %d não existe".formatted(id));
	}

	
}
