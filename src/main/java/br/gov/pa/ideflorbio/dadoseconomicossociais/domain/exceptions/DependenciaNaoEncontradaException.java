package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class DependenciaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public DependenciaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public DependenciaNaoEncontradaException(Long id) {
		this("A dependência de código %d não existe".formatted(id));
	}

	
}
