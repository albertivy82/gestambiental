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
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.UsuarioNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.UsuariosRepository;

@Service
public class UsuarioService {
	
	private static final String ENTIDADE_EM_USO = "O usuario de id %d nõ pode ser apagado, pois está "
			+ "sendo utilizado em um relacionamento";
	
	@Autowired
	UsuariosRepository usuarios;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Usuario inserir(Usuario usuario) {
		
		return usuarios.save(usuario);	
	}
	
	
	@Transactional
	public Usuario buscarEntidade(Long id) {
		
		Usuario entrevistadorAtual = usuarios
				.findById(id).orElseThrow(()->new UsuarioNaoEncontradoException(id));
		return entrevistadorAtual;
		
	}
	
	
	
	public List<Usuario> listarTodos(){
		
		return usuarios.findAll();
	}
	
	
	public UsuarioDTO buscaPorId(Long id){
		Usuario usuario = usuarios
				.findById(id).orElseThrow(()->new UsuarioNaoEncontradoException(id));
		return mapper.map(usuario, UsuarioDTO.class);
	}
	
	public UsuarioDTO buscarPorNome(String nome) {
		Usuario usuario = usuarios.findByNome(nome)
				.orElseThrow(()->new UsuarioNaoEncontradoException(nome));
		
		return mapper.map(usuario, UsuarioDTO.class);
	}
	
	@Transactional
	public void apagar(long id) {
		try {
			usuarios.deleteById(id);
			usuarios.flush();
		}catch(EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException(id);
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(ENTIDADE_EM_USO, id));
		}
		
		
	}

}
