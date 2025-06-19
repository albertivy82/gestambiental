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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EmbarcacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.EmbarcacaoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Embarcacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.EmbarcacaoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "embarcacao")
@RestController
@RequestMapping("/embarcacao")
public class EmbarcacaoController {
	
	@Autowired
	EmbarcacaoService embarcacaoCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public EmbarcacaoDTO adicionar(@RequestBody @Valid EmbarcacaoInput embarcacaoInput) {
		try {
			
			Embarcacao embarcacao = mapper.map(embarcacaoInput, Embarcacao.class);
			return mapper.map(embarcacaoCadastro.inserir(embarcacao), EmbarcacaoDTO.class);
			
			}catch (PescaArtesanalNaoEncontradaException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public EmbarcacaoDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid EmbarcacaoInput embarcacaoInput) {
		try {
			Embarcacao embarcacaoAtual = embarcacaoCadastro.buscarEntidade(id);
		embarcacaoAtual.setPescaArtesanal(new PescaArtesanal());
		mapper.map(embarcacaoInput, embarcacaoAtual);
		return mapper.map(embarcacaoCadastro.inserir(embarcacaoAtual), EmbarcacaoDTO.class);
		}catch (PescaArtesanalNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<EmbarcacaoDTO> listar(){
		return embarcacaoCadastro
				.listarTodos().stream().map(t->mapper.map(t, EmbarcacaoDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public EmbarcacaoDTO Buscar(@PathVariable Long id) {
		return embarcacaoCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/pesca-artesanal-embarcacao/{pescaArtesanalId}")
	public List<EmbarcacaoDTO> buscarPorPescaArtesanal(@PathVariable Long pescaArtesanalId){
		return embarcacaoCadastro.buscarPorPescaArtesanal(pescaArtesanalId)
				.stream().map(d->mapper.map(d, EmbarcacaoDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		embarcacaoCadastro.excluir(id);
	}

}
