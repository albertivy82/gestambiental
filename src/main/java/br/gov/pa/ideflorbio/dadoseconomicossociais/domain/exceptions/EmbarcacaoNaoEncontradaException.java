package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class EmbarcacaoNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public EmbarcacaoNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public EmbarcacaoNaoEncontradaException(Long id) {
		this("Os dados sobre a destinação da pesca de código %d não existe".formatted(id));
	}

	
}
