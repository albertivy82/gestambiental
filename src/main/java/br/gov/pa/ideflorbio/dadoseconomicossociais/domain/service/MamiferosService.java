package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.MamiferosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.MamiferoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Mamiferos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.MamiferosRepository;

@Service
public class MamiferosService {
	
	private static final String ENTIDADE_EM_USO 
	= "A vegetação de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	MamiferosRepository mamiferos;
	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Mamiferos inserir(Mamiferos mamifero) {
		
		
		Long idEntrevistado = mamifero.getEntrevistado().getId();
		Entrevistado entrevistado = entrevistados.findById(idEntrevistado)
		.orElseThrow(()->new EntrevistadoNaoEncontradoException(idEntrevistado));
		mamifero.setEntrevistado(entrevistado);
		
		return mamiferos.save(mamifero);
	}
	
	
	public Mamiferos buscarEntidade(Long id) {
		
		Mamiferos mamiferoAtual = mamiferos.findById(id)
				.orElseThrow(()-> new MamiferoNaoEncontradoException(id));
		return inserir(mamiferoAtual);
	}
	
	
	
	public List<Mamiferos> listarTodos(){
		
	   return mamiferos.findAll(); 
		
	}
	
	
	public MamiferosDTO localizarEntidade(Long id) {
		
			Mamiferos mamifero = mamiferos.findById(id)
					.orElseThrow(()-> new MamiferoNaoEncontradoException(id));
		
		return mapper.map(mamifero, MamiferosDTO.class);
	}
	
	public List<MamiferosDTO> buscarPorEntrevistado(Long entrevistadoId){
		List<MamiferosDTO> mamiferosPorEntrevistado = mamiferos.findByEntrevistado(entrevistadoId)
				.stream().map(mamifero->mapper.map(mamifero, MamiferosDTO.class)).toList();
		
		return mamiferosPorEntrevistado;
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			mamiferos.deleteById(id);
			mamiferos.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new MamiferoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
