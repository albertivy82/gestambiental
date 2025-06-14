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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ServicosComunicacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.ServicosComunicacaoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ServicosComunicacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ServicosComunicacaoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;


@Api(tags = "Serviços de Comunicação")
@RestController
@RequestMapping("/servico-de-comunicacao")
public class ServicosComunicacaoController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ServicosComunicacaoService servicosComunicacaoCadastro;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ServicosComunicacaoDTO adicionar(@RequestBody @Valid ServicosComunicacaoInput servicoComunicacaoInput) {
		
		try {
			ServicosComunicacao servicoComunicacao = mapper.map(servicoComunicacaoInput, ServicosComunicacao.class);
			return mapper.map(servicosComunicacaoCadastro.inserir(servicoComunicacao), ServicosComunicacaoDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public ServicosComunicacaoDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid ServicosComunicacaoInput servicoComunicacaoInput) {
		
		try {
			 ServicosComunicacao servicoComunicacao =  servicosComunicacaoCadastro.buscarEntidade(id);
			 servicoComunicacao.setBenfeitoria(new Benfeitoria());
			 mapper.map(servicoComunicacaoInput, servicoComunicacao);
			return mapper.map(servicosComunicacaoCadastro.inserir(servicoComunicacao), ServicosComunicacaoDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<ServicosComunicacaoDTO> listar(){
		return servicosComunicacaoCadastro
				.listarTodos().stream().map(t->mapper.map(t, ServicosComunicacaoDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public ServicosComunicacaoDTO Buscar(@PathVariable Long id) {
		return servicosComunicacaoCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/benfeitoria-servico-de-comunicacao/{benfeitoriaId}")
	public List<ServicosComunicacaoDTO> BuscarPoBenfeitoria(@PathVariable Long benfeitoriaId) {
		return servicosComunicacaoCadastro.buscarPorBenfeitoria(benfeitoriaId)
				.stream().map(m->mapper.map(m,ServicosComunicacaoDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		servicosComunicacaoCadastro.excluir(id);
	}
	
	
}
