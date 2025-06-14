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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.MoradorDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.MoradorInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Morador;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.MoradoresService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "Morador")
@RestController
@RequestMapping("/morador")
public class MoradorController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	MoradoresService moradoresCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public MoradorDTO adicionar(@RequestBody @Valid MoradorInput moradorInput) {
		
		try {
			Morador morador = mapper.map(moradorInput, Morador.class);
			return mapper.map(moradoresCadastro.inserir(morador), MoradorDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public MoradorDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid MoradorInput moradorInput) {
		
		try {
			 Morador morador =  moradoresCadastro.buscarEntidade(id);
			 morador.setBenfeitoria(new Benfeitoria());
			 mapper.map(moradorInput, morador);
			return mapper.map(moradoresCadastro.inserir(morador), MoradorDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<MoradorDTO> listar(){
		return moradoresCadastro
				.listarTodos().stream().map(t->mapper.map(t, MoradorDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public MoradorDTO Buscar(@PathVariable Long id) {
		return moradoresCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-morador/{benfeitoriaId}")
	public List<MoradorDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return moradoresCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,MoradorDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		moradoresCadastro.excluir(id);
	}
	
	
}
