package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.FaunaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.FaunaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Fauna;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.FaunaRepository;

@Service
public class FaunaService {
	
	private static final String ENTIDADE_EM_USO 
	= "A vegetação de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	FaunaRepository faunas;
	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Fauna inserir(Fauna fauna) {
		
		
		Long idEntrevistado = fauna.getEntrevistado().getId();
		Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
		.orElseThrow(()->new EntrevistadoNaoEncontradoException(idEntrevistado));
		fauna.setEntrevistado(entrevistado);
		
		return faunas.save(fauna);
	}
	
	
	public Fauna buscarEntidade(Long id) {
		
		Fauna faunaAtual = faunas.findById(id)
				.orElseThrow(()-> new FaunaNaoEncontradaException(id));
		return inserir(faunaAtual);
	}
	
	
	
	public List<Fauna> listarTodos(){
		
	   return faunas.findAll(); 
		
	}
	
	
	public FaunaDTO localizarEntidade(Long id) {
		
			Fauna fauna = faunas.findById(id)
					.orElseThrow(()-> new FaunaNaoEncontradaException(id));
		
		return mapper.map(fauna, FaunaDTO.class);
	}
	
	public List<FaunaDTO> buscarPorEntrevistado(Long entrevistadoId){
		List<FaunaDTO> faunasPorEntrevistado = faunas.findByEntrevistado(entrevistadoId)
				.stream().map(fauna->mapper.map(fauna, FaunaDTO.class)).toList();
		
		return faunasPorEntrevistado;
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			faunas.deleteById(id);
			faunas.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new FaunaNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
