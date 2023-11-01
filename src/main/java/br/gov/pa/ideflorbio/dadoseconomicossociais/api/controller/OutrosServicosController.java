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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.OutrosServicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.OutrosServicosInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.OutrosServicos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.OutrosServicosService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "Outros-Servicos")
@RestController
@RequestMapping("/outros-servicos")
public class OutrosServicosController {
	
	
	@Autowired
	OutrosServicosService servicos;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public OutrosServicosDTO adicionar(@RequestBody @Valid OutrosServicosInput Input) {
		try {
			
			OutrosServicos outrosServicos = mapper.map(Input, OutrosServicos.class);
			return mapper.map(servicos.inserir(outrosServicos), OutrosServicosDTO.class);
		
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public OutrosServicosDTO atualizar(@PathVariable Long id, 
			@RequestBody @Valid OutrosServicosInput Input) {
		try {
			OutrosServicos servicoAtual = servicos.buscarEntidade(id);
			mapper.map(Input, servicoAtual);
		return mapper.map(servicos.inserir(servicoAtual), OutrosServicosDTO.class);
		}catch(Exception e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@GetMapping
	public List<OutrosServicosDTO> listar(){
		return servicos
		.listarTodos().stream().map(t->mapper.map(t, OutrosServicosDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public OutrosServicosDTO Buscar(@PathVariable Long id) {
		return servicos.localizarEntidade(id);
	}
	
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		servicos.excluir(id);
	}
	


}
