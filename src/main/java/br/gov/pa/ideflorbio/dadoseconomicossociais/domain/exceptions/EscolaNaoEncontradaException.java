package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class EscolaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public EscolaNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public EscolaNaoEncontradaException(Long id) {
		this("A escola de código %d não existe".formatted(id));
	}

	
}
