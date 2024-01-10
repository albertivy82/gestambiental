package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AlimentacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.DadosDeConsumoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Alimentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.AlimentacaoRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;

@Service
public class AlimentacaoService {
	
	
	private static final String ENTIDADE_EM_USO = "Os dados de Alimentacao registrados com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";

	
	@Autowired
	AlimentacaoRepository alimentos;
	
	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	@Autowired
	ModelMapper mapper;
	
	
		
	@Transactional
	public Alimentacao inserir(Alimentacao alimento) {
		
		return mapper.map(alimentos.save(alimento), Alimentacao.class);
	}
	
	@Transactional
	public Alimentacao buscarEntidade(Long id) {
		
		return alimentos.findById(id)
				.orElseThrow(()-> new DadosDeConsumoNaoEncontradoException(id));
		
	}
	
	public List<Long> IdAlimentcaoPorBenfeitoria (long benfeitoria) {
		return alimentos.alimentosBenfeitoria(benfeitoria);
	}
	
	
	public List<Alimentacao> listarTodos(){
		
	   return alimentos.findAll(); 
		
	}
	
	public AlimentacaoDTO localizarEntidade(Long id) {
		
			Alimentacao alimento = alimentos.findById(id)
					.orElseThrow(()-> new DadosDeConsumoNaoEncontradoException(id));
		
		return mapper.map(alimento, AlimentacaoDTO.class);
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			alimentos.deleteById(id);
			alimentos.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new DadosDeConsumoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
