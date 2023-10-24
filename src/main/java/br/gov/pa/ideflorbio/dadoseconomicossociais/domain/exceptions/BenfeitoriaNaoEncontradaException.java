package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class BenfeitoriaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public BenfeitoriaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public BenfeitoriaNaoEncontradaException(Long id) {
		this("Benfeitoria de código %d não existe".formatted(id));
	}

	
}
