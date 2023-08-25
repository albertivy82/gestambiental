package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EscolaReciboDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PostoDeSaudeDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EscolaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PostoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Escola;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PostoDeSaude;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.EscolasRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.LocalidadesRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PostosDeSaudeRepository;

@Service
public class PostoDeSaudeService {
	
	private static final String ENTIDADE_EM_USO 
	= "O posto de saúde de código %d não pode ser removido, pois está em uso";
	
	@Autowired
	PostosDeSaudeRepository postos;
	
	@Autowired
	LocalidadesRepository localidades;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public PostoDeSaude inserir(PostoDeSaude posto) {
		
		
		Long idLocalidade = posto.getLocalidade().getId();
		Localidade localidade = localidades.findById(idLocalidade)
		.orElseThrow(()->new LocalidadeNaoEncontradaException(idLocalidade));
		posto.setLocalidade(localidade);
		
		return postos.save(posto);
	}
	
	
	public PostoDeSaude buscarEntidade(Long id) {
		
		PostoDeSaude postoAtual = postos.findById(id)
				.orElseThrow(()-> new PostoNaoEncontradoException(id));
		return inserir(postoAtual);
	}
	
	
	
	public List<PostoDeSaude> listarTodos(){
		
	   return postos.findAll(); 
		
	}
	
	public PostoDeSaudeDTO localizarEntidade(Long id) {
		
			PostoDeSaude posto = postos.findById(id)
					.orElseThrow(()-> new PostoNaoEncontradoException(id));
		
		return mapper.map(posto, PostoDeSaudeDTO.class);
	}
		
	@Transactional
	public void excluir(Long id) {
		try {
			postos.deleteById(id);
			postos.flush();
		}catch(EmptyResultDataAccessException e) {
			
			throw new PostoNaoEncontradoException(id);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(ENTIDADE_EM_USO.formatted(id));
		}
	}	
	
	
	

}
