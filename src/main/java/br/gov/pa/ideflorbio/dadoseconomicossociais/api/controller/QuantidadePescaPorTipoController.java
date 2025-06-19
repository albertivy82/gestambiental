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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.QuantidadePescaPorTipoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.QuantidadePescaPorTipoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.QuantidadePescaPorTipo;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.QuantidadePescaPorTipoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "quantidadePescaPorTipo")
@RestController
@RequestMapping("/quantidade-pesca-por-tipo")
public class QuantidadePescaPorTipoController {
	
	@Autowired
	QuantidadePescaPorTipoService quantidadePescaPorTipoCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public QuantidadePescaPorTipoDTO adicionar(@RequestBody @Valid QuantidadePescaPorTipoInput quantidadePescaPorTipoInput) {
		try {
			
			QuantidadePescaPorTipo quantidadePescaPorTipo = mapper.map(quantidadePescaPorTipoInput, QuantidadePescaPorTipo.class);
			return mapper.map(quantidadePescaPorTipoCadastro.inserir(quantidadePescaPorTipo), QuantidadePescaPorTipoDTO.class);
			
			}catch (PescaArtesanalNaoEncontradaException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public QuantidadePescaPorTipoDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid QuantidadePescaPorTipoInput quantidadePescaPorTipoInput) {
		try {
			QuantidadePescaPorTipo quantidadePescaPorTipoAtual = quantidadePescaPorTipoCadastro.buscarEntidade(id);
		quantidadePescaPorTipoAtual.setPescaArtesanal(new PescaArtesanal());
		mapper.map(quantidadePescaPorTipoInput, quantidadePescaPorTipoAtual);
		return mapper.map(quantidadePescaPorTipoCadastro.inserir(quantidadePescaPorTipoAtual), QuantidadePescaPorTipoDTO.class);
		}catch (PescaArtesanalNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<QuantidadePescaPorTipoDTO> listar(){
		return quantidadePescaPorTipoCadastro
				.listarTodos().stream().map(t->mapper.map(t, QuantidadePescaPorTipoDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public QuantidadePescaPorTipoDTO Buscar(@PathVariable Long id) {
		return quantidadePescaPorTipoCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/pesca-artesanal-quantidade-pesca-por-tipo/{pescaArtesanalId}")
	public List<QuantidadePescaPorTipoDTO> buscarPorPescaArtesanal(@PathVariable Long pescaArtesanalId){
		return quantidadePescaPorTipoCadastro.buscarPorPescaArtesanal(pescaArtesanalId)
				.stream().map(d->mapper.map(d, QuantidadePescaPorTipoDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		quantidadePescaPorTipoCadastro.excluir(id);
	}

}
