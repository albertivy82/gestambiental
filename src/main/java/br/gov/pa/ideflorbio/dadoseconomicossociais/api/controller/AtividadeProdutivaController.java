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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AtividadeProdutivaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.AtividadeProdutivaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtividadeProdutiva;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.AtividadesProdutivasService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "Atividade Produtiva")
@RestController
@RequestMapping("/atividade-produtiva")
public class AtividadeProdutivaController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	AtividadesProdutivasService atividadeProdutivaesCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public AtividadeProdutivaDTO adicionar(@RequestBody @Valid AtividadeProdutivaInput atividadeProdutivaInput) {
		
		try {
			AtividadeProdutiva atividadeProdutiva = mapper.map(atividadeProdutivaInput, AtividadeProdutiva.class);
			return mapper.map(atividadeProdutivaesCadastro.inserir(atividadeProdutiva), AtividadeProdutivaDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public AtividadeProdutivaDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid AtividadeProdutivaInput atividadeProdutivaInput) {
		
		try {
			 AtividadeProdutiva atividadeProdutiva =  atividadeProdutivaesCadastro.buscarEntidade(id);
			 atividadeProdutiva.setBenfeitoria(new Benfeitoria());
			 mapper.map(atividadeProdutivaInput, atividadeProdutiva);
			return mapper.map(atividadeProdutivaesCadastro.inserir(atividadeProdutiva), AtividadeProdutivaDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<AtividadeProdutivaDTO> listar(){
		return atividadeProdutivaesCadastro
				.listarTodos().stream().map(t->mapper.map(t, AtividadeProdutivaDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public AtividadeProdutivaDTO Buscar(@PathVariable Long id) {
		return atividadeProdutivaesCadastro.localzarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-atividadeProdutiva/{benfeitoriaId}")
	public List<AtividadeProdutivaDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return atividadeProdutivaesCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,AtividadeProdutivaDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		atividadeProdutivaesCadastro.excluir(id);
	}
	
	
}
