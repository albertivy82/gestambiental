package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public GrupoNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public GrupoNaoEncontradoException(Long id) {
		this(String.format("Grupo de código %d não existe", id));
	}

	
}
