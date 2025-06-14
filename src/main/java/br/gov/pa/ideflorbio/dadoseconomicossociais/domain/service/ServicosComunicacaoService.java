package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ServicosComunicacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ServicosComunicacaoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ServicosComunicacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.ServicosComunicacaoRepository;

@Service
public class ServicosComunicacaoService {
	
	private static final String ENTIDADE_EM_USO 
	= "O Servico de Comunicacao de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	ServicosComunicacaoRepository servicosComunicacaoes;
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public ServicosComunicacao inserir(ServicosComunicacao servicosComunicacao) {
		
		Long idBenfeitoria = servicosComunicacao.getBenfeitoria().getId();
		Benfeitoria benfeitoria = benfeitorias.findById(idBenfeitoria)
		.orElseThrow(()->new BenfeitoriaNaoEncontradaException(idBenfeitoria));
		
		servicosComunicacao.setBenfeitoria(benfeitoria);
		
		return servicosComunicacaoes.save(servicosComunicacao);
	}
	
	
	@Transactional
	public ServicosComunicacao buscarEntidade(Long id) {
		
		ServicosComunicacao servicosComunicacaoAtual = servicosComunicacaoes.findById(id)
				.orElseThrow(()->new ServicosComunicacaoNaoEncontradoException(id));
				
		return servicosComunicacaoAtual;
		
	}
		
	
	public List<ServicosComunicacao> listarTodos(){ return servicosComunicacaoes.findAll(); }
	
	
	public ServicosComunicacaoDTO localizarEntidade(Long id) {
		
			ServicosComunicacao servicosComunicacao = servicosComunicacaoes.findById(id)
					.orElseThrow(()-> new BenfeitoriaNaoEncontradaException(id));
		
		return mapper.map(servicosComunicacao, ServicosComunicacaoDTO.class);
	}
	
	
	
	public List<ServicosComunicacao> buscarPorBenfeitoria(Long benfeitoriaId) {
		
		List<ServicosComunicacao> servicosComunicacaoesDB = servicosComunicacaoes.findByBenfeitoriaId(benfeitoriaId);
		
	    return servicosComunicacaoesDB;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			servicosComunicacaoes.deleteById(id);
			servicosComunicacaoes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new ServicosComunicacaoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
