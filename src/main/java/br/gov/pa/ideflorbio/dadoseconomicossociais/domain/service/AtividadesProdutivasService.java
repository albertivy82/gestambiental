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
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtividadeProdutiva;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AtividadesProdutivasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ImoveisRepository;


@Service
public class AtividadesProdutivasService {
	
	private static final String ENTIDADE_EM_USO = "A atividade produtiva de id %d nõ pode ser apagada, pois está "
			+ "sendo utilizado em um relacionamento";
	
	@Autowired
	AtividadesProdutivasRepository atividadesProdutivas;
	
	@Autowired
	ImoveisRepository imoveis;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public AtividadeProdutiva inserir(AtividadeProdutiva atividadeProdutiva) {
		
		Long idImovel = atividadeProdutiva.getImovel().getId();
		Imovel imovel = imoveis.findById(idImovel)
		.orElseThrow(()->new ImovelNaoEncontradoException(idImovel));
		
		atividadeProdutiva.setImovel(imovel);
		
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
	
	public AtividadeProdutivaDTO localzarentidade(Long id) {
		
		AtividadeProdutiva atividadeProdutiva = atividadesProdutivas.findById(id)
				.orElseThrow(()->new AtividadeNaoEncontradaException(id));
		
		return mapper.map(atividadeProdutiva, AtividadeProdutivaDTO.class);
		
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
