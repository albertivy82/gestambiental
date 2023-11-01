package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.OutrosServicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ServicoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.OutrosServicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.OutrosServicosRepository;
@Service
public class OutrosServicosService {
	
	
	private static final String ENTIDADE_EM_USO = "Os dados sobre serviços públis básicos com id %d nõ podem ser apagados, pois estão "
			+ "sendo utilizados em um relacionamento";

	
	@Autowired
	OutrosServicosRepository servicos;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public OutrosServicos inserir(OutrosServicos servicosOutros) {
		
		return servicos.save(servicosOutros);
	}
	
	@Transactional
	public OutrosServicos buscarEntidade(Long id) {
		
		OutrosServicos servicosOutros = servicos.findById(id)
				.orElseThrow(()-> new ServicoNaoEncontradoException(id));
		
		return servicosOutros;	
	}
	
	public List<OutrosServicos> listarTodos(){
		
	   return servicos.findAll(); 
		
	}
	
	public OutrosServicosDTO localizarEntidade(Long id) {
		OutrosServicos servicosOutros = servicos.findById(id)
					.orElseThrow(()-> new ServicoNaoEncontradoException(id));
		
		return mapper.map(servicosOutros, OutrosServicosDTO.class);
	}
	
		
	@Transactional
	public void excluir(Long id) {
		try {
			servicos.deleteById(id);
			servicos.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new ServicoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	


}
