package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.DestinoPescaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.DestinoPescaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.DestinoPesca;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.DestinoPescaRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PescaArtesanalRepository;

@Service
public class DestinoPescaService {
	
	private static final String ENTIDADE_EM_USO 
	= "Os dados sobre Água de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	DestinoPescaRepository destinoPescas;
	
	@Autowired
	PescaArtesanalRepository pescasArtesanais;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public DestinoPesca inserir(DestinoPesca destinoPesca) {
		
		Long idPescaArtesanal = destinoPesca.getPescaArtesanal().getId();
		PescaArtesanal pescaArtesanal = pescasArtesanais.findById(idPescaArtesanal)
		.orElseThrow(()->new PescaArtesanalNaoEncontradaException(idPescaArtesanal));
		
		destinoPesca.setPescaArtesanal(pescaArtesanal);
		
		return destinoPescas.save(destinoPesca);
	}
	
	
	@Transactional
	public DestinoPesca buscarEntidade(Long id) {
		
		DestinoPesca destinoPescaAtual = destinoPescas.findById(id)
				.orElseThrow(()->new DestinoPescaNaoEncontradaException(id));
				
		return destinoPescaAtual;
		
	}
		
	
	public List<DestinoPesca> listarTodos(){ return destinoPescas.findAll(); }
	
	
	public DestinoPescaDTO localizarEntidade(Long id) {
		
			DestinoPesca destinoPesca = destinoPescas.findById(id)
					.orElseThrow(()-> new PescaArtesanalNaoEncontradaException(id));
		
		return mapper.map(destinoPesca, DestinoPescaDTO.class);
	}
	
	
	
	public List<DestinoPesca> buscarPorPescaArtesanal(Long pescaArtesanalId) {
		
		List<DestinoPesca> destinoPescasDB = destinoPescas.findByPescaArtesanalId(pescaArtesanalId);
		
	    return destinoPescasDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			destinoPescas.deleteById(id);
			destinoPescas.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new DestinoPescaNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
