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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PescaArtesanalDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.PescaArtesanalInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.PescaArtesanalService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "PescaArtesanal")
@RestController
@RequestMapping("/pesca-artesanal")
public class PescaArtesanalController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	PescaArtesanalService pescaArtesanalesCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public PescaArtesanalDTO adicionar(@RequestBody @Valid PescaArtesanalInput pescaArtesanalInput) {
		
		try {
			PescaArtesanal pescaArtesanal = mapper.map(pescaArtesanalInput, PescaArtesanal.class);
			return mapper.map(pescaArtesanalesCadastro.inserir(pescaArtesanal), PescaArtesanalDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public PescaArtesanalDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid PescaArtesanalInput pescaArtesanalInput) {
		
		try {
			 PescaArtesanal pescaArtesanal =  pescaArtesanalesCadastro.buscarEntidade(id);
			 pescaArtesanal.setBenfeitoria(new Benfeitoria());
			 mapper.map(pescaArtesanalInput, pescaArtesanal);
			return mapper.map(pescaArtesanalesCadastro.inserir(pescaArtesanal), PescaArtesanalDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<PescaArtesanalDTO> listar(){
		return pescaArtesanalesCadastro
				.listarTodos().stream().map(t->mapper.map(t, PescaArtesanalDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public PescaArtesanalDTO Buscar(@PathVariable Long id) {
		return pescaArtesanalesCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-pesca-artesanal/{benfeitoriaId}")
	public List<PescaArtesanalDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return pescaArtesanalesCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,PescaArtesanalDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		pescaArtesanalesCadastro.excluir(id);
	}
	
	
}
