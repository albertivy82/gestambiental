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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.CreditoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.CreditoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Credito;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.CreditoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "Credito")
@RestController
@RequestMapping("/credito")
public class CreditoController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CreditoService creditosCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public CreditoDTO adicionar(@RequestBody @Valid CreditoInput creditoInput) {
		
		try {
			Credito credito = mapper.map(creditoInput, Credito.class);
			return mapper.map(creditosCadastro.inserir(credito), CreditoDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public CreditoDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid CreditoInput creditoInput) {
		
		try {
			 Credito credito =  creditosCadastro.buscarEntidade(id);
			 credito.setBenfeitoria(new Benfeitoria());
			 mapper.map(creditoInput, credito);
			return mapper.map(creditosCadastro.inserir(credito), CreditoDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<CreditoDTO> listar(){
		return creditosCadastro
				.listarTodos().stream().map(t->mapper.map(t, CreditoDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public CreditoDTO Buscar(@PathVariable Long id) {
		return creditosCadastro.localzarentidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-credito/{benfeitoriaId}")
	public List<CreditoDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return creditosCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,CreditoDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		creditosCadastro.excluir(id);
	}
	
	
}
