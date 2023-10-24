package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.CoordenadaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.CoordenadaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Coordenada;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.CoordenadasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.LocalidadesRepository;

@Service
public class CoordenadaService {
	
	private static final String ENTIDADE_EM_USO 
	= "A coordenada de código %d não pode ser removida, pois está em uso";
	
	@Autowired
	CoordenadasRepository coordenadas;
	
	@Autowired
	LocalidadesRepository localidades;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Coordenada inserir(Coordenada coordenada) {
		 
		
		Long idLocalidade = coordenada.getLocalidade().getId();
		
		Localidade localidade = localidades.findById(idLocalidade)
		.orElseThrow(()->new LocalidadeNaoEncontradaException(idLocalidade));
		
		coordenada.setLocalidade(localidade);
		
		return coordenadas.save(coordenada);
	}
	
	public Coordenada buscarEntidade(Long id) {
		
		Coordenada coordenada = coordenadas.findById(id)
				.orElseThrow(()->new CoordenadaNaoEncontradaException(id));
		
		return coordenada;
		
	}
	

	public List<CoordenadaDTO> findByLocalidadeId(Long localidadeId) {
		
		List<CoordenadaDTO> listaDeCoordenadas = coordenadas.findByLocalidadeId(localidadeId).stream().map(result->mapper.map(result, CoordenadaDTO.class)).toList();
               										
               
       System.out.println(listaDeCoordenadas);
        
        return listaDeCoordenadas;
		
	}
	
	
	
	
	@Transactional
	public void excluir(Long id) {
		try {
			coordenadas.deleteById(id);
			coordenadas.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new CoordenadaNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
