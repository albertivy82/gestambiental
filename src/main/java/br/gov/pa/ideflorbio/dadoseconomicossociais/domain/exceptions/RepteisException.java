package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class RepteisException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public RepteisException(String message) {
		super(message);
		
	}
	
	public RepteisException(Long id) {
		this("Os dados sobre repteis de código %d não existe".formatted(id));
	}

	
}
