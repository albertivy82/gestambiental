package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class DependenciasException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public DependenciasException(String message) {
		super(message);
		
	}
	
	public DependenciasException(Long id) {
		this("A dependência de código %d não existe".formatted(id));
	}

	
}
