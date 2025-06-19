package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions;

public class ParticipacaoInstituicaoNaoEncontradaException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public ParticipacaoInstituicaoNaoEncontradaException(String message) {
		super(message);
	}
	
	public ParticipacaoInstituicaoNaoEncontradaException(Long id) {
		this("Posto de código %d não existe".formatted(id));
	}

}
