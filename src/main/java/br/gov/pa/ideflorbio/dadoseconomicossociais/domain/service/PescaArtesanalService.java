package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PescaArtesanalDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PescaArtesanalRepository;

@Service
public class PescaArtesanalService {
	
	private static final String ENTIDADE_EM_USO 
	= "O pescaArtesanal de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	PescaArtesanalRepository pescas;
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public PescaArtesanal inserir(PescaArtesanal pescaArtesanal) {
		
		Long idBenfeitoria = pescaArtesanal.getBenfeitoria().getId();
		Benfeitoria benfeitoria = benfeitorias.findById(idBenfeitoria)
		.orElseThrow(()->new BenfeitoriaNaoEncontradaException(idBenfeitoria));
		
		pescaArtesanal.setBenfeitoria(benfeitoria);
		
		return pescas.save(pescaArtesanal);
	}
	
	
	@Transactional
	public PescaArtesanal buscarEntidade(Long id) {
		
		PescaArtesanal pescaArtesanalAtual = pescas.findById(id)
				.orElseThrow(()->new PescaArtesanalNaoEncontradaException(id));
				
		return pescaArtesanalAtual;
		
	}
		
	
	public List<PescaArtesanal> listarTodos(){ return pescas.findAll(); }
	
	
	public PescaArtesanalDTO localizarEntidade(Long id) {
		
			PescaArtesanal pescaArtesanal = pescas.findById(id)
					.orElseThrow(()-> new BenfeitoriaNaoEncontradaException(id));
		
		return mapper.map(pescaArtesanal, PescaArtesanalDTO.class);
	}
	
	
	
	public List<PescaArtesanal> buscarPorBenfeitoria(Long benfeitoriaId) {
		
		List<PescaArtesanal> pescasDB = pescas.findByBenfeitoriaId(benfeitoriaId);
		
	    return pescasDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			pescas.deleteById(id);
			pescas.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new PescaArtesanalNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
