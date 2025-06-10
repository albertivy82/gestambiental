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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.RepteisDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.RepteisInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Repteis;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.RepteisService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "reptil")
@RestController
@RequestMapping("/reptil")
public class ReptilController {
	
	@Autowired
	RepteisService reptilCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public RepteisDTO adicionar(@RequestBody @Valid RepteisInput reptilInput) {
		try {
			
			Repteis reptil = mapper.map(reptilInput, Repteis.class);
			return mapper.map(reptilCadastro.inserir(reptil), RepteisDTO.class);
			
			}catch (EntrevistadoNaoEncontradoException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public RepteisDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid RepteisInput reptilInput) {
		try {
			Repteis reptilAtual = reptilCadastro.buscarEntidade(id);
		reptilAtual.setEntrevistado(new Entrevistado());
		mapper.map(reptilInput, reptilAtual);
		return mapper.map(reptilCadastro.inserir(reptilAtual), RepteisDTO.class);
		}catch (EntrevistadoNaoEncontradoException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<RepteisDTO> listar(){
		return reptilCadastro
				.listarTodos().stream().map(t->mapper.map(t, RepteisDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public RepteisDTO Buscar(@PathVariable Long id) {
		return reptilCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/entrevistado-reptil/{entrevistadoId}")
	public List<RepteisDTO> buscarPorEntrevistado(@PathVariable Long entrevistadoId){
		return reptilCadastro.buscarPorEntrevistado(entrevistadoId);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		reptilCadastro.excluir(id);
	}

}
