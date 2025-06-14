package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AguaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.AguaNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Agua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AguaRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;

@Service
public class AguaService {
	
	private static final String ENTIDADE_EM_USO 
	= "Os dados sobre Água de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	AguaRepository aguas;
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Agua inserir(Agua agua) {
		
		Long idBenfeitoria = agua.getBenfeitoria().getId();
		Benfeitoria benfeitoria = benfeitorias.findById(idBenfeitoria)
		.orElseThrow(()->new BenfeitoriaNaoEncontradaException(idBenfeitoria));
		
		agua.setBenfeitoria(benfeitoria);
		
		return aguas.save(agua);
	}
	
	
	@Transactional
	public Agua buscarEntidade(Long id) {
		
		Agua aguaAtual = aguas.findById(id)
				.orElseThrow(()->new AguaNaoEncontradoException(id));
				
		return aguaAtual;
		
	}
		
	
	public List<Agua> listarTodos(){ return aguas.findAll(); }
	
	
	public AguaDTO localizarEntidade(Long id) {
		
			Agua agua = aguas.findById(id)
					.orElseThrow(()-> new BenfeitoriaNaoEncontradaException(id));
		
		return mapper.map(agua, AguaDTO.class);
	}
	
	
	
	public List<Agua> buscarPorBenfeitoria(Long benfeitoriaId) {
		
		List<Agua> aguasDB = aguas.findByBenfeitoriaId(benfeitoriaId);
		
	    return aguasDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			aguas.deleteById(id);
			aguas.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new AguaNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
