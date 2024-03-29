package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public PermissaoNaoEncontradaException(String message) {
		super(message);
		
	}
	
	public PermissaoNaoEncontradaException(Long id) {
		this("Permissao de código %d não existe".formatted(id));
	}

	
}
