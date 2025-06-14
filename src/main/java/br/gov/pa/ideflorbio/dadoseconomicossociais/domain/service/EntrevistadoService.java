package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EntrevistadoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.AtividadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EntrevistadosRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.LocalidadesRepository;

@Service
public class EntrevistadoService {
	
	
	private static final String ENTIDADE_EM_USO = "O entrevistado de id %d nõ pode ser apagado, pois está "
			+ "sendo utilizado em um relacionamento";

	
	@Autowired
	EntrevistadosRepository entrevistados;
	
	@Autowired
	LocalidadesRepository localidades;
	
	
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Entrevistado inserir(Entrevistado entrevistado) {
		
		
		Long idLocalidade = entrevistado.getLocalidade().getId();
		Localidade localidade = localidades.findById(idLocalidade)
				.orElseThrow(()->new LocalidadeNaoEncontradaException(idLocalidade));
	
		entrevistado.setLocalidade(localidade);
		
		
		
		return entrevistados.save(entrevistado);
	}
	
	
	@Transactional
	public Entrevistado buscarEntidade(Long id) {
		
		Entrevistado entrevistado = entrevistados.findById(id)
				.orElseThrow(()->new AtividadeNaoEncontradaException(id));	
		
		return entrevistado;
	}
	
	public EntrevistadoDTO localizarEntidade(Long id) {
		
		Entrevistado entrevistado = entrevistados.findById(id)
				.orElseThrow(()-> new EntrevistadoNaoEncontradoException(id));
	
	return mapper.map(entrevistado, EntrevistadoDTO.class);
}

	
	
	public List<Entrevistado> listarTodos(){
		
	   return entrevistados.findAll(); 
		
	}
	
		
     public List<EntrevistadoDTO> findByLocalidade(Long localidadeId){
		
		return entrevistados.findByLocalidadeId(localidadeId).stream().map(i->mapper.map(i, EntrevistadoDTO.class)).toList();
		
	}
     
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			entrevistados.deleteById(id);
			entrevistados.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new EntrevistadoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
