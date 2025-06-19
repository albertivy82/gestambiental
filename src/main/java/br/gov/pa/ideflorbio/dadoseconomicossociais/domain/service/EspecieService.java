package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EspecieDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EspecieNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Especie;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EspecieRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PescaArtesanalRepository;

@Service
public class EspecieService {
	
	private static final String ENTIDADE_EM_USO 
	= "Os dados sobre Água de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	EspecieRepository embarcacoes;
	
	@Autowired
	PescaArtesanalRepository pescasArtesanais;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Especie inserir(Especie quantidadePorTipo) {
		
		Long idPescaArtesanal = quantidadePorTipo.getPescaArtesanal().getId();
		PescaArtesanal pescaArtesanal = pescasArtesanais.findById(idPescaArtesanal)
		.orElseThrow(()->new PescaArtesanalNaoEncontradaException(idPescaArtesanal));
		
		quantidadePorTipo.setPescaArtesanal(pescaArtesanal);
		
		return embarcacoes.save(quantidadePorTipo);
	}
	
	
	@Transactional
	public Especie buscarEntidade(Long id) {
		
		Especie quantidadePorTipoAtual = embarcacoes.findById(id)
				.orElseThrow(()->new EspecieNaoEncontradaException(id));
				
		return quantidadePorTipoAtual;
		
	}
		
	
	public List<Especie> listarTodos(){ return embarcacoes.findAll(); }
	
	
	public EspecieDTO localizarEntidade(Long id) {
		
			Especie quantidadePorTipo = embarcacoes.findById(id)
					.orElseThrow(()-> new PescaArtesanalNaoEncontradaException(id));
		
		return mapper.map(quantidadePorTipo, EspecieDTO.class);
	}
	
	
	
	public List<Especie> buscarPorPescaArtesanal(Long pescaArtesanalId) {
		
		List<Especie> quantidadePorTiposDB = embarcacoes.findByPescaArtesanalId(pescaArtesanalId);
		
	    return quantidadePorTiposDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			embarcacoes.deleteById(id);
			embarcacoes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new EspecieNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
