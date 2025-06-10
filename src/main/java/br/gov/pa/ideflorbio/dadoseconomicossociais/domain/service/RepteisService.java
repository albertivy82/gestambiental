package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.RepteisDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ReptilNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Repteis;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.RepteisRepository;

@Service
public class RepteisService {
	
	private static final String ENTIDADE_EM_USO 
	= "A vegetação de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	RepteisRepository repteis;
	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Repteis inserir(Repteis reptil) {
		
		
		Long idEntrevistado = reptil.getEntrevistado().getId();
		Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
		.orElseThrow(()->new EntrevistadoNaoEncontradoException(idEntrevistado));
		reptil.setEntrevistado(entrevistado);
		
		return repteis.save(reptil);
	}
	
	
	public Repteis buscarEntidade(Long id) {
		
		Repteis reptilAtual = repteis.findById(id)
				.orElseThrow(()-> new ReptilNaoEncontradoException(id));
		return inserir(reptilAtual);
	}
	
	
	
	public List<Repteis> listarTodos(){
		
	   return repteis.findAll(); 
		
	}
	
	
	public RepteisDTO localizarEntidade(Long id) {
		
			Repteis reptil = repteis.findById(id)
					.orElseThrow(()-> new ReptilNaoEncontradoException(id));
		
		return mapper.map(reptil, RepteisDTO.class);
	}
	
	public List<RepteisDTO> buscarPorEntrevistado(Long entrevistadoId){
		List<RepteisDTO> repteisPorEntrevistado = repteis.findByEntrevistado(entrevistadoId)
				.stream().map(reptil->mapper.map(reptil, RepteisDTO.class)).toList();
		
		return repteisPorEntrevistado;
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			repteis.deleteById(id);
			repteis.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new ReptilNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
