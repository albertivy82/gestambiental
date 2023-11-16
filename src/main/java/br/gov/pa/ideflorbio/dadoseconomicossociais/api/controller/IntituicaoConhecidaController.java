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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.InstituicaoConhecidaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.InstituicaoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.InstituicaoConhecida;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.InstituicoesService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "Instituições Conhecidas")
@RestController
@RequestMapping("/intituicoes-conhecidas")
public class IntituicaoConhecidaController {
	
	
	@Autowired
	InstituicoesService instituicoesCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public InstituicaoConhecidaDTO adicionar(@RequestBody @Valid InstituicaoInput instituicaoInput) {
		
		try {
			InstituicaoConhecida instituicao = mapper.map(instituicaoInput, InstituicaoConhecida.class);
			return mapper.map(instituicoesCadastro.inserir(instituicao), InstituicaoConhecidaDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@PutMapping("/{id}")
	public InstituicaoConhecidaDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid InstituicaoInput instituicaoInput) {
		
		try {
			InstituicaoConhecida instituicao =  instituicoesCadastro.buscarEntidade(id);
			 instituicao.setBenfeitoria(new Benfeitoria());
			 mapper.map(instituicaoInput, instituicao);
			return mapper.map(instituicoesCadastro.inserir(instituicao), InstituicaoConhecidaDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	

	
	@GetMapping
	public List<InstituicaoConhecidaDTO> listar(){
		return instituicoesCadastro
				.listarTodos().stream().map(t->mapper.map(t, InstituicaoConhecidaDTO.class)).toList();

	}
	
	@GetMapping("/{id}")
	public InstituicaoConhecidaDTO Buscar(@PathVariable Long id) {
		return instituicoesCadastro.localizarEntidade(id);
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		instituicoesCadastro.excluir(id);
	}
	


}
