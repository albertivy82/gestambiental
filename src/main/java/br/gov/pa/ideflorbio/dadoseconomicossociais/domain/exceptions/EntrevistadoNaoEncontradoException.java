package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class EntrevistadoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public EntrevistadoNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public EntrevistadoNaoEncontradoException(Long id) {
		this("Entrevistado de código %d não existe".formatted(id));
	}

	
}
