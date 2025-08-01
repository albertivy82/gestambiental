package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;

import java.util.List;

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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.RendaOutrasFontesDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.RendasOutrasFontesInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.RendaOutrasFontes;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.RendasService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "Renda")
@RestController
@RequestMapping("/outras-fontes-de-renda")
public class RendasController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	RendasService rendasCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public RendaOutrasFontesDTO adicionar(@RequestBody @Valid RendasOutrasFontesInput rendaInput) {
		
		try {
			RendaOutrasFontes renda = mapper.map(rendaInput, RendaOutrasFontes.class);
			return mapper.map(rendasCadastro.inserir(renda), RendaOutrasFontesDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public RendaOutrasFontesDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid RendasOutrasFontesInput rendaInput) {
		
		try {
			 RendaOutrasFontes renda =  rendasCadastro.buscarEntidade(id);
			 renda.setBenfeitoria(new Benfeitoria());
			 mapper.map(rendaInput, renda);
			return mapper.map(rendasCadastro.inserir(renda), RendaOutrasFontesDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<RendaOutrasFontesDTO> listar(){
		return rendasCadastro
				.listarTodos().stream().map(t->mapper.map(t, RendaOutrasFontesDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public RendaOutrasFontesDTO Buscar(@PathVariable Long id) {
		return rendasCadastro.localzarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-outras-fontes-de-renda/{benfeitoriaId}")
	public List<RendaOutrasFontesDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return rendasCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,RendaOutrasFontesDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		rendasCadastro.excluir(id);
	}
	
	
}
