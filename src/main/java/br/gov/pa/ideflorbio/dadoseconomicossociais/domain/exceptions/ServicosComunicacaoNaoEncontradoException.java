package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ServicosComunicacaoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ServicosComunicacaoNaoEncontradoException(String message) {
		super(message);
		
	}
	
	public ServicosComunicacaoNaoEncontradoException(Long id) {
		this("O seviço de código %d não existe".formatted(id));
	}

	
}
