package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ViolenciasSofridasDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.ViolenciaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Residencia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Violencia;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ViolenciaService;
import io.swagger.annotations.Api;



@Api(tags = "Violência")
@RestController
@RequestMapping("/violencia")
public class ViolenciaController {
	
	
	@Autowired
	ViolenciaService violenciaCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ViolenciasSofridasDTO adicionar(@RequestBody @Valid ViolenciaInput violenciaInput) {
		
		try {
			Violencia violencia = mapper.map(violenciaInput, Violencia.class);
			return mapper.map(violenciaCadastro.inserir(violencia), ViolenciasSofridasDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	@PutMapping("/{id}")
	public ViolenciasSofridasDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid ViolenciaInput violenciaInput) {
		
		try {
			 Violencia violencia =  violenciaCadastro.buscarEntidade(id);
			 violencia.setResidencia(new Residencia());
			 mapper.map(violenciaInput, violencia);
			return mapper.map(violenciaCadastro.inserir(violencia), ViolenciasSofridasDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@GetMapping
	public List<ViolenciasSofridasDTO> listar(){
		return violenciaCadastro
		.listarTodos().stream().map(t->mapper.map(t, ViolenciasSofridasDTO.class)).toList();
	
	}
	
	@GetMapping("/{id}")
	public ViolenciasSofridasDTO Buscar(@PathVariable Long id) {
		return violenciaCadastro.localizarEntidade(id);
	}
	
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		violenciaCadastro.excluir(id);
	}
	


}
