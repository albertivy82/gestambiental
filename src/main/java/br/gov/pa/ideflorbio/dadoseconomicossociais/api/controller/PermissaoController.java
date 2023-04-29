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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PermissaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.PermissaoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Permissao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.PermissaoService;
import io.swagger.annotations.Api;

@Api(tags = "Permissao")
@RestController
@RequestMapping("/permissao")
public class PermissaoController {
	
	
	@Autowired
	PermissaoService permissaoCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Usuario.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public PermissaoDTO adicionar(@RequestBody @Valid PermissaoInput permissaoInput) {
		
		Permissao permissao = mapper.map(permissaoInput, Permissao.class);
		return mapper.map(permissaoCadastro.inserir(permissao), PermissaoDTO.class);
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{id}")
	public PermissaoDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid PermissaoInput permissaoInput) {

		Permissao permissaoAtual = permissaoCadastro.buscarEntidade(id);
		mapper.map(permissaoInput, permissaoAtual);
		return mapper.map(permissaoCadastro.inserir(permissaoAtual), PermissaoDTO.class);
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<PermissaoDTO> listar(){
		return permissaoCadastro
				.listarTodos().stream().map(t->mapper.map(t, PermissaoDTO.class)).toList();
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping("/buscaporid/{id}")
	public PermissaoDTO Buscar(@PathVariable Long id) {
		return permissaoCadastro.buscaPorId(id);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		permissaoCadastro.apagar(id);
	}

	

}
