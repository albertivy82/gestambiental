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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.DestinoPescaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.DestinoPescaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.DestinoPesca;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.DestinoPescaService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "destinoPesca")
@RestController
@RequestMapping("/destino-pesca")
public class DestinoPescaController {
	
	@Autowired
	DestinoPescaService destinoPescaCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public DestinoPescaDTO adicionar(@RequestBody @Valid DestinoPescaInput destinoPescaInput) {
		try {
			
			DestinoPesca destinoPesca = mapper.map(destinoPescaInput, DestinoPesca.class);
			return mapper.map(destinoPescaCadastro.inserir(destinoPesca), DestinoPescaDTO.class);
			
			}catch (PescaArtesanalNaoEncontradaException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public DestinoPescaDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid DestinoPescaInput destinoPescaInput) {
		try {
			DestinoPesca destinoPescaAtual = destinoPescaCadastro.buscarEntidade(id);
		destinoPescaAtual.setPescaArtesanal(new PescaArtesanal());
		mapper.map(destinoPescaInput, destinoPescaAtual);
		return mapper.map(destinoPescaCadastro.inserir(destinoPescaAtual), DestinoPescaDTO.class);
		}catch (PescaArtesanalNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<DestinoPescaDTO> listar(){
		return destinoPescaCadastro
				.listarTodos().stream().map(t->mapper.map(t, DestinoPescaDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public DestinoPescaDTO Buscar(@PathVariable Long id) {
		return destinoPescaCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/pesca-artesanal-destino-pesca/{pescaArtesanalId}")
	public List<DestinoPescaDTO> buscarPorPescaArtesanal(@PathVariable Long pescaArtesanalId){
		return destinoPescaCadastro.buscarPorPescaArtesanal(pescaArtesanalId)
				.stream().map(d->mapper.map(d, DestinoPescaDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		destinoPescaCadastro.excluir(id);
	}

}
