package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ServicoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ServicoNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public ServicoNaoEncontradoException(Long id) {
		this("O seviço de código %d não existe".formatted(id));
	}

	
}
