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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AlimentacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.AlimentacaoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Alimentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.AlimentacaoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "Dados de alimentcao")
@RestController
@RequestMapping("/alimentacao")
public class AlimentacaoController {
	
	
	@Autowired
	AlimentacaoService alimentcaoCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public AlimentacaoDTO adicionar(@RequestBody @Valid AlimentacaoInput alimentacaoInput) {
		try{
			Alimentacao alimento = mapper.map(alimentacaoInput, Alimentacao.class);
			return mapper.map(alimentcaoCadastro.inserir(alimento), AlimentacaoDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public AlimentacaoDTO atualizar(@PathVariable Long id, 
			@RequestBody @Valid AlimentacaoInput alimentacaoInput) {
		try {
			Alimentacao alimentacaoAtual = alimentcaoCadastro.buscarEntidade(id);
			mapper.map(alimentacaoInput, alimentacaoAtual);
			return mapper.map(alimentcaoCadastro.inserir(alimentacaoAtual), AlimentacaoDTO.class); 
			
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	
	@GetMapping
	public List<AlimentacaoDTO> listar(){
		return alimentcaoCadastro
				.listarTodos().stream().map(t->mapper.map(t, AlimentacaoDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public AlimentacaoDTO Buscar(@PathVariable Long id) {
		return alimentcaoCadastro.localizarEntidade(id);
	}
	
	
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		alimentcaoCadastro.excluir(id);
	}
	


}
