package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PeixesDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PeixeNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Peixes;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PeixesRepository;

@Service
public class PeixesService {
	
	private static final String ENTIDADE_EM_USO 
	= "O peixe de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	PeixesRepository peixes;
	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Peixes inserir(Peixes peixe) {
		
		
		Long idEntrevistado = peixe.getEntrevistado().getId();
		Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
		.orElseThrow(()->new EntrevistadoNaoEncontradoException(idEntrevistado));
		peixe.setEntrevistado(entrevistado);
		
		return peixes.save(peixe);
	}
	
	
	public Peixes buscarEntidade(Long id) {
		
		Peixes peixeAtual = peixes.findById(id)
				.orElseThrow(()-> new PeixeNaoEncontradoException(id));
		return inserir(peixeAtual);
	}
	
	
	
	public List<Peixes> listarTodos(){
		
	   return peixes.findAll(); 
		
	}
	
	
	public PeixesDTO localizarEntidade(Long id) {
		
			Peixes peixe = peixes.findById(id)
					.orElseThrow(()-> new PeixeNaoEncontradoException(id));
		
		return mapper.map(peixe, PeixesDTO.class);
	}
	
	public List<PeixesDTO> buscarPorEntrevistado(Long entrevistadoId){
		List<PeixesDTO> peixesPorEntrevistado = peixes.findByEntrevistado(entrevistadoId)
				.stream().map(peixe->mapper.map(peixe, PeixesDTO.class)).toList();
		
		return peixesPorEntrevistado;
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			peixes.deleteById(id);
			peixes.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new PeixeNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
