package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class AguaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public AguaException(String message) {
		super(message);
		
	}
	
	public AguaException(Long id) {
		this("Os dados relativosà qualidade de água"
				+ " de código %d não existe".formatted(id));
	}

	
}
