package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.UsuarioDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.GrupoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.UsuarioNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Grupo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Permissao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.GruposRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.PermissoesRepository;

@Service
public class GupoService {
	
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
	
	
	public UsuarioDTO buscaPorId(Long id){
		Grupo grupo = grupos
				.findById(id).orElseThrow(()->new UsuarioNaoEncontradoException(id));
		return mapper.map(grupo, UsuarioDTO.class);
	}
	
	
	public void VinculaGrupo(Long grupoId, Long permissaoId) {
		
				
		Grupo grupo =  grupos.findById(grupoId)
				.orElseThrow(()->new GrupoNaoEncontradoException(grupoId));
		
		Permissao permissao =  permissoes.findById(permissaoId)
				.orElseThrow(()->new UsuarioNaoEncontradoException(permissaoId));
		
		grupo.getPermissao().add(permissao);
	}
	
   public void DesvinculaGrupo(Long grupoId, Long permissaoId) {
		
	   Grupo grupo =  grupos.findById(grupoId)
				.orElseThrow(()->new GrupoNaoEncontradoException(grupoId));
		
		Permissao permissao =  permissoes.findById(permissaoId)
				.orElseThrow(()->new UsuarioNaoEncontradoException(permissaoId));
		
		grupo.getPermissao().remove(permissao);
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
