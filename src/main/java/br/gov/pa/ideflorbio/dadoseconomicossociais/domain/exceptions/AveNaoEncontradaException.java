package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class AveNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public AveNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public AveNaoEncontradaException(Long id) {
		this("Os dados sobre aves"
				+ " de código %d não existe".formatted(id));
	}

	
}
