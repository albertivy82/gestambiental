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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EspecieDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.EspecieInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.PescaArtesanalNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Especie;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PescaArtesanal;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.EspecieService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "especie")
@RestController
@RequestMapping("/especie")
public class EspecieController {
	
	@Autowired
	EspecieService especieCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public EspecieDTO adicionar(@RequestBody @Valid EspecieInput especieInput) {
		try {
			
			Especie especie = mapper.map(especieInput, Especie.class);
			return mapper.map(especieCadastro.inserir(especie), EspecieDTO.class);
			
			}catch (PescaArtesanalNaoEncontradaException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public EspecieDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid EspecieInput especieInput) {
		try {
			Especie especieAtual = especieCadastro.buscarEntidade(id);
		especieAtual.setPescaArtesanal(new PescaArtesanal());
		mapper.map(especieInput, especieAtual);
		return mapper.map(especieCadastro.inserir(especieAtual), EspecieDTO.class);
		}catch (PescaArtesanalNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<EspecieDTO> listar(){
		return especieCadastro
				.listarTodos().stream().map(t->mapper.map(t, EspecieDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public EspecieDTO Buscar(@PathVariable Long id) {
		return especieCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/pesca-artesanal-especie/{pescaArtesanalId}")
	public List<EspecieDTO> buscarPorPescaArtesanal(@PathVariable Long pescaArtesanalId){
		return especieCadastro.buscarPorPescaArtesanal(pescaArtesanalId)
				.stream().map(d->mapper.map(d, EspecieDTO.class)).toList();
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		especieCadastro.excluir(id);
	}

}
