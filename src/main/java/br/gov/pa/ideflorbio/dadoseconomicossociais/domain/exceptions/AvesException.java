package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class AvesException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public AvesException(String message) {
		super(message);
		
	}
	
	public AvesException(Long id) {
		this("Os dados sobre aves"
				+ " de código %d não existe".formatted(id));
	}

	
}
