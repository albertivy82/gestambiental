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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AvesDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.AvesInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Aves;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.AveService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "ave")
@RestController
@RequestMapping("/ave")
public class AveController {
	
	@Autowired
	AveService aveCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public AvesDTO adicionar(@RequestBody @Valid AvesInput aveInput) {
		try {
			
			Aves ave = mapper.map(aveInput, Aves.class);
			return mapper.map(aveCadastro.inserir(ave), AvesDTO.class);
			
			}catch (EntrevistadoNaoEncontradoException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public AvesDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid AvesInput aveInput) {
		try {
			Aves aveAtual = aveCadastro.buscarEntidade(id);
		aveAtual.setEntrevistado(new Entrevistado());
		mapper.map(aveInput, aveAtual);
		return mapper.map(aveCadastro.inserir(aveAtual), AvesDTO.class);
		}catch (EntrevistadoNaoEncontradoException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<AvesDTO> listar(){
		return aveCadastro
				.listarTodos().stream().map(t->mapper.map(t, AvesDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public AvesDTO Buscar(@PathVariable Long id) {
		return aveCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/entrevistado-ave/{entrevistadoId}")
	public List<AvesDTO> buscarPorEntrevistado(@PathVariable Long entrevistadoId){
		return aveCadastro.buscarPorEntrevistado(entrevistadoId);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		aveCadastro.excluir(id);
	}

}
