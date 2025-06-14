package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class AguaNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public AguaNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public AguaNaoEncontradoException(Long id) {
		this("Os dados relativosà qualidade de água"
				+ " de código %d não existe".formatted(id));
	}

	
}
