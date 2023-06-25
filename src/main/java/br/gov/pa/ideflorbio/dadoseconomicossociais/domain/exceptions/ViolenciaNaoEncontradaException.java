package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ViolenciaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ViolenciaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public ViolenciaNaoEncontradaException(Long id) {
		this("Os dados sobre violencia de código %d não existem".formatted(id));
	}

	
}
