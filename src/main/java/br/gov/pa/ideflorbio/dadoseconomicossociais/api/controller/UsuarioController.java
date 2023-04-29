package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.UsuarioDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.SenhaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.UsuarioInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.UsuarioService;
import io.swagger.annotations.Api;

@Api(tags = "Usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuarioCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Usuario.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public UsuarioDTO adicionar(@RequestBody @Valid UsuarioInput usuarioInput) {
		
		Usuario usuario = mapper.map(usuarioInput, Usuario.class);
		return mapper.map(usuarioCadastro.inserir(usuario), UsuarioDTO.class);
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{id}")
	public UsuarioDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid UsuarioInput usuarioInput) {

		Usuario entrevistadorAtual = usuarioCadastro.buscarEntidade(id);
		mapper.map(usuarioInput, entrevistadorAtual);
		return mapper.map(usuarioCadastro.inserir(entrevistadorAtual), UsuarioDTO.class);
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("alterar-senha/{id}")
	public void alterarSenha(@PathVariable Long id, 
		@RequestBody @Valid SenhaInput senha) {
		
		usuarioCadastro.AlterarSenha(id, senha.getSenhaAtual(), senha.getNovaSenha());
	}

	@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<UsuarioDTO> listar(){
		return usuarioCadastro
				.listarTodos().stream().map(t->mapper.map(t, UsuarioDTO.class)).toList();
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping("/buscaporid/{id}")
	public UsuarioDTO Buscar(@PathVariable Long id) {
		return usuarioCadastro.buscaPorId(id);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping("/buscapornome/{nome}")
	public UsuarioDTO BuscarPorNome(@PathVariable String nome) {
		return usuarioCadastro.buscarPorNome(nome);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping("/buscapormatricula/{matricula}")
	public UsuarioDTO BuscarPorMatricula(@PathVariable String matricula) {
		return usuarioCadastro.buscarPorMatricula(matricula);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{idUsuario}/grupo/{idGrupo}")
	public void VincularUsuarioGrupo(@PathVariable Long idUsuario, @PathVariable Long idGrupo) {
		usuarioCadastro.VinculaGrupo(idUsuario, idGrupo);		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{idUsuario}/grupo/{idGrupo}")
	public void DesvincularUsuarioGrupo(@PathVariable Long idUsuario, @PathVariable Long idGrupo) {
		usuarioCadastro.DesvinculaGrupo(idUsuario, idGrupo);	
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		usuarioCadastro.apagar(id);
	}

	

}
