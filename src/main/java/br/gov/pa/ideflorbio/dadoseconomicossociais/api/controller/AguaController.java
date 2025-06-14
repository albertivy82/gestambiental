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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AguaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.AguaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Agua;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.AguaService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "Água")
@RestController
@RequestMapping("/agua")
public class AguaController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	AguaService aguasCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public AguaDTO adicionar(@RequestBody @Valid AguaInput aguaInput) {
		
		try {
			Agua agua = mapper.map(aguaInput, Agua.class);
			return mapper.map(aguasCadastro.inserir(agua), AguaDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public AguaDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid AguaInput aguaInput) {
		
		try {
			 Agua agua =  aguasCadastro.buscarEntidade(id);
			 agua.setBenfeitoria(new Benfeitoria());
			 mapper.map(aguaInput, agua);
			return mapper.map(aguasCadastro.inserir(agua), AguaDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<AguaDTO> listar(){
		return aguasCadastro
				.listarTodos().stream().map(t->mapper.map(t, AguaDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public AguaDTO Buscar(@PathVariable Long id) {
		return aguasCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-agua/{benfeitoriaId}")
	public List<AguaDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return aguasCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,AguaDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		aguasCadastro.excluir(id);
	}
	
	
}
