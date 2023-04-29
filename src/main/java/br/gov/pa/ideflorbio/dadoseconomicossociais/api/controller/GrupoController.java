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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.GrupoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.GrupoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Grupo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.GrupoService;
import io.swagger.annotations.Api;

@Api(tags = "Grupo")
@RestController
@RequestMapping("/grupo")
public class GrupoController {
	
	
	@Autowired
	GrupoService grupoCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	
	@CheckSecurity.Usuario.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public GrupoDTO adicionar(@RequestBody @Valid GrupoInput grupoInput) {
		
		Grupo grupo = mapper.map(grupoInput, Grupo.class);
		return mapper.map(grupoCadastro.inserir(grupo), GrupoDTO.class);
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{id}")
	public GrupoDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid GrupoInput grupoInput) {

		Grupo grupoAtual = grupoCadastro.buscarEntidade(id);
		mapper.map(grupoInput, grupoAtual);
		return mapper.map(grupoCadastro.inserir(grupoAtual), GrupoDTO.class);
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<GrupoDTO> listar(){
		return grupoCadastro
				.listarTodos().stream().map(t->mapper.map(t, GrupoDTO.class)).toList();
		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@GetMapping("/buscaporid/{id}")
	public GrupoDTO Buscar(@PathVariable Long id) {
		return grupoCadastro.buscaPorId(id);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		grupoCadastro.apagar(id);
	}

	

}
