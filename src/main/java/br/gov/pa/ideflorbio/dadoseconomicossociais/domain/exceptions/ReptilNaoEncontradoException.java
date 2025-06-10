package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ReptilNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ReptilNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public ReptilNaoEncontradoException(Long id) {
		this("Os dados sobre repteis de código %d não existe".formatted(id));
	}

	
}
