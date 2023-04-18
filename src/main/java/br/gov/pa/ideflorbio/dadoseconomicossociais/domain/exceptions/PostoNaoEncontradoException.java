package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class PostoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public PostoNaoEncontradoException(String message) {
		super(message);
	}
	
	public PostoNaoEncontradoException(Long id) {
		this(String.format("Posto de código %d não existe", id));
	}

}
