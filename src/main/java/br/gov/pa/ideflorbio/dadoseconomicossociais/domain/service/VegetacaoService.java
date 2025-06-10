package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.VegetacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.VegetacaoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Vegetacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.VegetacaoRepository;

@Service
public class VegetacaoService {
	
	private static final String ENTIDADE_EM_USO 
	= "A vegetação de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	VegetacaoRepository vegetacoes;
	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Vegetacao inserir(Vegetacao vegetacao) {
		
		
		Long idEntrevistado = vegetacao.getEntrevistado().getId();
		Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
		.orElseThrow(()->new EntrevistadoNaoEncontradoException(idEntrevistado));
		vegetacao.setEntrevistado(entrevistado);
		
		return vegetacoes.save(vegetacao);
	}
	
	
	public Vegetacao buscarEntidade(Long id) {
		
		Vegetacao vegetacaoAtual = vegetacoes.findById(id)
				.orElseThrow(()-> new VegetacaoNaoEncontradaException(id));
		return inserir(vegetacaoAtual);
	}
	
	
	
	public List<Vegetacao> listarTodos(){
		
	   return vegetacoes.findAll(); 
		
	}
	
	
	public VegetacaoDTO localizarEntidade(Long id) {
		
			Vegetacao vegetacao = vegetacoes.findById(id)
					.orElseThrow(()-> new VegetacaoNaoEncontradaException(id));
		
		return mapper.map(vegetacao, VegetacaoDTO.class);
	}
	
	public List<VegetacaoDTO> buscarPorEntrevistado(Long entrevistadoId){
		List<VegetacaoDTO> vegetacoesPorEntrevistado = vegetacoes.findByEntrevistado(entrevistadoId)
				.stream().map(vegetacao->mapper.map(vegetacao, VegetacaoDTO.class)).toList();
		
		return vegetacoesPorEntrevistado;
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			vegetacoes.deleteById(id);
			vegetacoes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new VegetacaoNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
