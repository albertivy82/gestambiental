package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.GrupoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PermissaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.GrupoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PermissaoNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.UsuarioNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Grupo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Permissao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.GruposRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PermissoesRepository;

@Service
public class GrupoService {
	
	private static final String ENTIDADE_EM_USO = "O grupo de id %d não pode ser apagado, pois está "
			+ "sendo utilizado em um relacionamento";
	
	
	@Autowired
	GruposRepository grupos;
	
	@Autowired
	PermissoesRepository permissoes;
		
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Grupo inserir(Grupo grupo) {
		return grupos.save(grupo);	
	}
	
	
	@Transactional
	public Grupo buscarEntidade(Long id) {
		
		Grupo grupoAtual = grupos
				.findById(id).orElseThrow(()->new GrupoNaoEncontradoException(id));
		return grupoAtual;
		
	}
	
	
	
	public List<Grupo> listarTodos(){
		
		return grupos.findAll();
	}
	
	
	public GrupoDTO buscaPorId(Long id){
		Grupo grupo = grupos
				.findById(id).orElseThrow(()->new UsuarioNaoEncontradoException(id));
		return mapper.map(grupo, GrupoDTO.class);
	}
	
	public List<PermissaoDTO> listaPermissoes(Long id){
		
		Grupo grupo = grupos.findById(id)
				.orElseThrow(()-> new LocalidadeNaoEncontradaException(id));
		
		List<PermissaoDTO> listaDePermissoes = grupo.getPermissoes()
				.stream().map(e->mapper.map(e, PermissaoDTO.class)).toList();
		
		return listaDePermissoes;
	}
	
	@Transactional
	public void VinculaPermissao(Long grupoId, Long permissaoId) {
		
				
		Grupo grupo =  grupos.findById(grupoId)
				.orElseThrow(()->new GrupoNaoEncontradoException(grupoId));
		
		Permissao permissao =  permissoes.findById(permissaoId)
				.orElseThrow(()->new PermissaoNaoEncontradaException(permissaoId));
		
		System.out.println(permissao.getNome() + permissao.getId());
		grupo.getPermissoes().add(permissao);
		
	}
	
	@Transactional
   public void DesvinculaPermissao(Long grupoId, Long permissaoId) {
		
	   Grupo grupo =  grupos.findById(grupoId)
				.orElseThrow(()->new GrupoNaoEncontradoException(grupoId));
		
		Permissao permissao =  permissoes.findById(permissaoId)
				.orElseThrow(()->new UsuarioNaoEncontradoException(permissaoId));
		
		grupo.getPermissoes().remove(permissao);
	}
   
   
	
	@Transactional
	public void apagar(long id) {
		try {
			grupos.deleteById(id);
			grupos.flush();
		}catch(EmptyResultDataAccessException e) {
			throw new GrupoNaoEncontradoException(id);
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(ENTIDADE_EM_USO, id));
		}
		
		
	}

}
