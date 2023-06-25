package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ResidenciaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ResidenciaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public ResidenciaNaoEncontradaException(Long id) {
		this("A residêsncia de código %d não existe".formatted(id));
	}

	
}
