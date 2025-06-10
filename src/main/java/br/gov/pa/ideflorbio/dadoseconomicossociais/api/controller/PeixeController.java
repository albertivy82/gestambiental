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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PeixesDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.PeixeInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Peixes;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.PeixesService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "peixe")
@RestController
@RequestMapping("/peixe")
public class PeixeController {
	
	@Autowired
	PeixesService vegetacaoCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public PeixesDTO adicionar(@RequestBody @Valid PeixeInput vegetacaoInput) {
		try {
			
			Peixes vegetacao = mapper.map(vegetacaoInput, Peixes.class);
			return mapper.map(vegetacaoCadastro.inserir(vegetacao), PeixesDTO.class);
			
			}catch (EntrevistadoNaoEncontradoException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public PeixesDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid PeixeInput vegetacaoInput) {
		try {
			Peixes vegetacaoAtual = vegetacaoCadastro.buscarEntidade(id);
		vegetacaoAtual.setEntrevistado(new Entrevistado());
		mapper.map(vegetacaoInput, vegetacaoAtual);
		return mapper.map(vegetacaoCadastro.inserir(vegetacaoAtual), PeixesDTO.class);
		}catch (EntrevistadoNaoEncontradoException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<PeixesDTO> listar(){
		return vegetacaoCadastro
				.listarTodos().stream().map(t->mapper.map(t, PeixesDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public PeixesDTO Buscar(@PathVariable Long id) {
		return vegetacaoCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/entrevistado-peixe/{entrevistadoId}")
	public List<PeixesDTO> buscarPorEntrevistado(@PathVariable Long entrevistadoId){
		return vegetacaoCadastro.buscarPorEntrevistado(entrevistadoId);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		vegetacaoCadastro.excluir(id);
	}

}
