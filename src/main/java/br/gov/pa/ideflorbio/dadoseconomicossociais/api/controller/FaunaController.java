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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.FaunaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.FaunaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Fauna;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.FaunaService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "fauna")
@RestController
@RequestMapping("/fauna")
public class FaunaController {
	
	@Autowired
	FaunaService faunaCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public FaunaDTO adicionar(@RequestBody @Valid FaunaInput faunaInput) {
		try {
			
			Fauna fauna = mapper.map(faunaInput, Fauna.class);
			return mapper.map(faunaCadastro.inserir(fauna), FaunaDTO.class);
			
			}catch (EntrevistadoNaoEncontradoException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public FaunaDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid FaunaInput faunaInput) {
		try {
			Fauna faunaAtual = faunaCadastro.buscarEntidade(id);
		faunaAtual.setEntrevistado(new Entrevistado());
		mapper.map(faunaInput, faunaAtual);
		return mapper.map(faunaCadastro.inserir(faunaAtual), FaunaDTO.class);
		}catch (EntrevistadoNaoEncontradoException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<FaunaDTO> listar(){
		return faunaCadastro
				.listarTodos().stream().map(t->mapper.map(t, FaunaDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public FaunaDTO Buscar(@PathVariable Long id) {
		return faunaCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/entrevistado-fauna/{entrevistadoId}")
	public List<FaunaDTO> buscarPorEntrevistado(@PathVariable Long entrevistadoId){
		return faunaCadastro.buscarPorEntrevistado(entrevistadoId);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		faunaCadastro.excluir(id);
	}

}
