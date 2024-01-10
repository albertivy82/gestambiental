package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.BenfeitoriaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.DependenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Dependencias;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.BenfeitoriasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.DependenciasRepository;


@Service
public class DependenciasService {
	
	private static final String ENTIDADE_EM_USO = "As dependências registrados com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";
	
	@Autowired
	DependenciasRepository dependencias;
	

	@Autowired
	BenfeitoriasRepository benfeitorias;
	
	@Autowired
	ModelMapper mapper;
	
	
		
	@Transactional
	public Dependencias inserir(Dependencias dependencia) {
		
		Long idBenfeitoria = dependencia.getBenfeitoria().getId();
			Benfeitoria benfeitoria = benfeitorias.findById(idBenfeitoria)
					.orElseThrow(()->new BenfeitoriaNaoEncontradaException(idBenfeitoria));
			
		dependencia.setBenfeitoria(benfeitoria);
		
		return mapper.map(dependencias.save(dependencia), Dependencias.class);
	}
	
		
	@Transactional
	public Dependencias buscarEntidade(Long id) {
		
		return dependencias.findById(id)
				.orElseThrow(()-> new DependenciaNaoEncontradaException(id));
		
	}
	
	public List<Dependencias> listarTodos(){
		
	   return dependencias.findAll(); 
		
	}
	
	
	
	public List<Dependencias> dependenciasdaBenfeitoria(Long bftId) {
		
		List<Dependencias> dependencia = dependencias.dependenciasDaDaBenfeitoria(bftId);
		
		return dependencia;
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			dependencias.deleteById(id);
			dependencias.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new DependenciaNaoEncontradaException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	

}
