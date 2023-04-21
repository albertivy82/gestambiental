package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PermissaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.GrupoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PermissaoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Permissao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PermissoesRepository;

@Service
public class PermissaoService {
	
	private static final String ENTIDADE_EM_USO = "A permissão de id %d não pode ser apagado, pois está "
			+ "sendo utilizado em um relacionamento";
	
		
	@Autowired
	PermissoesRepository permissoes;
		
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Permissao inserir(Permissao permissao) {
		return permissoes.save(permissao);	
	}
	
	
	@Transactional
	public Permissao buscarEntidade(Long id) {
		
		Permissao permissaoAtual = permissoes
				.findById(id).orElseThrow(()->new GrupoNaoEncontradoException(id));
		return permissaoAtual;
		
	}
	
	
	
	public List<Permissao> listarTodos(){
		
		return permissoes.findAll();
	}
	
	
	public PermissaoDTO buscaPorId(Long id){
		Permissao permissao = permissoes
				.findById(id).orElseThrow(()->new PermissaoNaoEncontradaException(id));
		return mapper.map(permissao, PermissaoDTO.class);
	}
	
	
	@Transactional
	public void apagar(long id) {
		try {
			permissoes.deleteById(id);
			permissoes.flush();
		}catch(EmptyResultDataAccessException e) {
			throw new PermissaoNaoEncontradaException(id);
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(ENTIDADE_EM_USO, id));
		}
		
		
	}

}
