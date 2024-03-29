package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public UsuarioNaoEncontradoException(Long id) {
		this("Entrevistador de código %d não existe".formatted(id));
	}

	
}
