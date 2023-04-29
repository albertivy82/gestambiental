package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.UsuarioDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeEmUsoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.GrupoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.NegocioException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.UsuarioNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Grupo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.GruposRepository;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.UsuariosRepository;

@Service
public class UsuarioService {
	
	private static final String ENTIDADE_EM_USO = "O usuario de id %d nõ pode ser apagado, pois está "
			+ "sendo utilizado em um relacionamento";
	
	@Autowired
	UsuariosRepository usuarios;
	
	@Autowired
	GruposRepository grupos;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ModelMapper mapper;
	
	@Transactional
	public Usuario inserir(Usuario usuario) {
		
		//usuarios.detach(usuario);
		
		Optional<Usuario> checkaEmail = usuarios.findByEmail(usuario.getEmail());
		Optional<Usuario> checkaCpf = usuarios.findByCpf(usuario.getCpf());
		Optional<Usuario> checkaMatricula = usuarios.findByMatricula(usuario.getMatricula());
		
		if(checkaEmail.isPresent()&&!checkaEmail.get().equals(usuario)){
			throw new NegocioException(String.format("O e-mail: %s não está disponível", usuario.getEmail()));
		}
		
		if(checkaCpf.isPresent()&&!checkaCpf.get().equals(usuario)){
			throw new NegocioException(String.format("O CPF: %s não está disponível", usuario.getCpf()));
		}
		
		if(checkaMatricula.isPresent()&&!checkaMatricula.get().equals(usuario)){
			throw new NegocioException(String.format("O matricula: %s não está disponível", usuario.getMatricula()));
		}
		
		if(usuario.isNovo()) {
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		}
		
		
		return usuarios.save(usuario);	
	}
	
	
	@Transactional
	public Usuario buscarEntidade(Long id) {
		
		Usuario usuarioAtual = usuarios
				.findById(id).orElseThrow(()->new UsuarioNaoEncontradoException(id));
		return usuarioAtual;
		
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
	
	public UsuarioDTO buscarPorMatricula(String matricula) {
		Usuario usuario = usuarios.findByMatricula(matricula)
				.orElseThrow(()->new UsuarioNaoEncontradoException(matricula));
		
		return mapper.map(usuario, UsuarioDTO.class);
	}
	
	@Transactional
	public void VinculaGrupo(Long usuarioId, Long grupoId) {
		
		Usuario usuario =  usuarios.findById(usuarioId)
				.orElseThrow(()->new UsuarioNaoEncontradoException(usuarioId));
		
		Grupo grupo =  grupos.findById(grupoId)
				.orElseThrow(()->new GrupoNaoEncontradoException(usuarioId));
		
		usuario.getGrupo().add(grupo);
	}
	
	@Transactional	
    public void DesvinculaGrupo(Long usuarioId, Long grupoId) {
		
		Usuario usuario =  usuarios.findById(usuarioId)
				.orElseThrow(()->new UsuarioNaoEncontradoException(usuarioId));
		
		Grupo grupo =  grupos.findById(grupoId)
				.orElseThrow(()->new GrupoNaoEncontradoException(usuarioId));
		
		usuario.getGrupo().remove(grupo);
	}
   
	@Transactional
   public void AlterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
	   Usuario usuario = usuarios.findById(usuarioId)
				.orElseThrow(()->new UsuarioNaoEncontradoException(usuarioId));
	   
	   if(!passwordEncoder.matches(senhaAtual, usuario.getSenha())) {
		   throw new NegocioException("A senha informada não confere");
	   }
	   
	   usuario.setSenha(passwordEncoder.encode(novaSenha));
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
