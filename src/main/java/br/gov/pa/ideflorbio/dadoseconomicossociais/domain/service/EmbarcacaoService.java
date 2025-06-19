package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EmbarcacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EmbarcacaoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Embarcacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EmbarcacaoRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PescaArtesanalRepository;

@Service
public class EmbarcacaoService {
	
	private static final String ENTIDADE_EM_USO 
	= "Os dados sobre Água de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	EmbarcacaoRepository embarcacoes;
	
	@Autowired
	PescaArtesanalRepository pescasArtesanais;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Embarcacao inserir(Embarcacao quantidadePorTipo) {
		
		Long idPescaArtesanal = quantidadePorTipo.getPescaArtesanal().getId();
		PescaArtesanal pescaArtesanal = pescasArtesanais.findById(idPescaArtesanal)
		.orElseThrow(()->new PescaArtesanalNaoEncontradaException(idPescaArtesanal));
		
		quantidadePorTipo.setPescaArtesanal(pescaArtesanal);
		
		return embarcacoes.save(quantidadePorTipo);
	}
	
	
	@Transactional
	public Embarcacao buscarEntidade(Long id) {
		
		Embarcacao quantidadePorTipoAtual = embarcacoes.findById(id)
				.orElseThrow(()->new EmbarcacaoNaoEncontradaException(id));
				
		return quantidadePorTipoAtual;
		
	}
		
	
	public List<Embarcacao> listarTodos(){ return embarcacoes.findAll(); }
	
	
	public EmbarcacaoDTO localizarEntidade(Long id) {
		
			Embarcacao quantidadePorTipo = embarcacoes.findById(id)
					.orElseThrow(()-> new PescaArtesanalNaoEncontradaException(id));
		
		return mapper.map(quantidadePorTipo, EmbarcacaoDTO.class);
	}
	
	
	
	public List<Embarcacao> buscarPorPescaArtesanal(Long pescaArtesanalId) {
		
		List<Embarcacao> quantidadePorTiposDB = embarcacoes.findByPescaArtesanalId(pescaArtesanalId);
		
	    return quantidadePorTiposDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			embarcacoes.deleteById(id);
			embarcacoes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new EmbarcacaoNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
