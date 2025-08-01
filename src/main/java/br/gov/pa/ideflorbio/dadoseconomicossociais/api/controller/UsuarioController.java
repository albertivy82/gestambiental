package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.NegocioException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.UsuarioService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;

@Api(tags = "Usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuarioCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public UsuarioDTO adicionar(@RequestBody @Valid UsuarioInput usuarioInput) {
		
		usuarioInput.setSenha(passwordEncoder.encode((usuarioInput.getCpf())));
		Usuario usuario = mapper.map(usuarioInput, Usuario.class);
		
		usuarioCadastro.checkAvailability(usuario);
		
		return mapper.map(usuarioCadastro.inserir(usuario), UsuarioDTO.class);
		
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@PutMapping("/{id}")
	public UsuarioDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid UsuarioInput usuarioInput) {
		usuarioInput.setSenha(passwordEncoder.encode((usuarioInput.getCpf())));
		Usuario usuarioAtual = usuarioCadastro.buscarEntidade(id);
		mapper.map(usuarioInput, usuarioAtual);
		
		try {
		usuarioCadastro.checkAvailability(usuarioAtual);
		}catch(NegocioException e) {
			throw e;
		}
		return mapper.map(usuarioCadastro.inserir(usuarioAtual), UsuarioDTO.class);
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("alterar-senha/{id}")
	public void alterarSenha(@PathVariable Long id, @RequestBody @Valid SenhaInput senha) {
		
		usuarioCadastro.AlterarSenha(id, senha.getSenhaAtual(), senha.getNovaSenha());
	}

	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@GetMapping
	public List<UsuarioDTO> listar(){
		return usuarioCadastro
				.listarTodos();
		//.stream().map(t->mapper.map(t, UsuarioDTO.class)).toList()
		
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@GetMapping("/buscaporid/{id}")
	public UsuarioDTO Buscar(@PathVariable Long id) {
		return usuarioCadastro.buscaPorId(id);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@GetMapping("/buscapornome/{nome}")
	public UsuarioDTO BuscarPorNome(@PathVariable String nome) {
		return usuarioCadastro.buscarPorNome(nome);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@GetMapping("/buscapormatricula/{matricula}")
	public UsuarioDTO BuscarPorMatricula(@PathVariable String matricula) {
		return usuarioCadastro.buscarPorMatricula(matricula);
	}
	
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		usuarioCadastro.apagar(id);
	}

	

}
