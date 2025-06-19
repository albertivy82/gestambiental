package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.QuantidadePescaPorTipoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.QuantidadePescaPorTipoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.QuantidadePescaPorTipo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PescaArtesanalRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.QuantidadePescaPorTipoRepository;

@Service
public class QuantidadePescaPorTipoService {
	
	private static final String ENTIDADE_EM_USO 
	= "Os dados sobre Água de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	QuantidadePescaPorTipoRepository quantidades;
	
	@Autowired
	PescaArtesanalRepository pescasArtesanais;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public QuantidadePescaPorTipo inserir(QuantidadePescaPorTipo quantidadePorTipo) {
		
		Long idPescaArtesanal = quantidadePorTipo.getPescaArtesanal().getId();
		PescaArtesanal pescaArtesanal = pescasArtesanais.findById(idPescaArtesanal)
		.orElseThrow(()->new PescaArtesanalNaoEncontradaException(idPescaArtesanal));
		
		quantidadePorTipo.setPescaArtesanal(pescaArtesanal);
		
		return quantidades.save(quantidadePorTipo);
	}
	
	
	@Transactional
	public QuantidadePescaPorTipo buscarEntidade(Long id) {
		
		QuantidadePescaPorTipo quantidadePorTipoAtual = quantidades.findById(id)
				.orElseThrow(()->new QuantidadePescaPorTipoNaoEncontradaException(id));
				
		return quantidadePorTipoAtual;
		
	}
		
	
	public List<QuantidadePescaPorTipo> listarTodos(){ return quantidades.findAll(); }
	
	
	public QuantidadePescaPorTipoDTO localizarEntidade(Long id) {
		
			QuantidadePescaPorTipo quantidadePorTipo = quantidades.findById(id)
					.orElseThrow(()-> new PescaArtesanalNaoEncontradaException(id));
		
		return mapper.map(quantidadePorTipo, QuantidadePescaPorTipoDTO.class);
	}
	
	
	
	public List<QuantidadePescaPorTipo> buscarPorPescaArtesanal(Long pescaArtesanalId) {
		
		List<QuantidadePescaPorTipo> quantidadePorTiposDB = quantidades.findByPescaArtesanalId(pescaArtesanalId);
		
	    return quantidadePorTiposDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			quantidades.deleteById(id);
			quantidades.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new QuantidadePescaPorTipoNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
