package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AtividadeProdutivaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.AtividadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtividadeProdutiva;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AtividadesProdutivasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;


@Service
public class AtividadesProdutivasService {
	
	private static final String ENTIDADE_EM_USO = "A atividade produtiva de id %d nõ pode ser apagada, pois está "
			+ "sendo utilizado em um relacionamento";
	
	@Autowired
	AtividadesProdutivasRepository atividadesProdutivas;
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public AtividadeProdutiva inserir(AtividadeProdutiva atividadeProdutiva) {
		
		Long idBenfeitoria = atividadeProdutiva.getBenfeitoria().getId();
		Benfeitoria benfeitoria = benfeitorias.findById(idBenfeitoria)
		.orElseThrow(()->new BenfeitoriaNaoEncontradaException(idBenfeitoria));
		
		atividadeProdutiva.setBenfeitoria(benfeitoria);
		
		return atividadesProdutivas.save(atividadeProdutiva);
	}
	
	
	@Transactional
	public AtividadeProdutiva buscarEntidade(Long id) {
		
		AtividadeProdutiva atividadeProdutiva = atividadesProdutivas.findById(id)
				.orElseThrow(()->new AtividadeNaoEncontradaException(id));	
		
		return atividadeProdutiva;
	}
	
	
	
	public List<AtividadeProdutiva> listarTodos(){
		
		return atividadesProdutivas.findAll();
	}
	
	public AtividadeProdutivaDTO localzarEntidade(Long id) {
		
		AtividadeProdutiva atividadeProdutiva = atividadesProdutivas.findById(id)
				.orElseThrow(()->new AtividadeNaoEncontradaException(id));
		
		return mapper.map(atividadeProdutiva, AtividadeProdutivaDTO.class);
		
	}
	
	
	
	public List<AtividadeProdutiva> buscarPorBenfeitoria(Long benfeitoriaId) {
			
			List<AtividadeProdutiva> atividadesProdutivasDB = atividadesProdutivas.findByBenfeitoriaId(benfeitoriaId);
		    return atividadesProdutivasDB;
	}
	
	
	
	@Transactional
	public void excluir(long id) {
		try {
			atividadesProdutivas.deleteById(id);
			atividadesProdutivas.flush();
		}catch(EmptyResultDataAccessException e) {
			throw new AtividadeNaoEncontradaException(id);
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
		
		
	}

}
