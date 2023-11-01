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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AtendimentoSaudeDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.AtendimentoSaudeInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.AtendimentoSaude;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.AtendimentoSaudeService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "Atendimento-saúde")
@RestController
@RequestMapping("/atendimento-saude")
public class AtendimentoSaudeController {
	
	
	@Autowired
	AtendimentoSaudeService atendimentos;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public AtendimentoSaudeDTO adicionar(@RequestBody @Valid AtendimentoSaudeInput input) {
		try {
			
			AtendimentoSaude atendimentoSaude = mapper.map(input, AtendimentoSaude.class);
			return mapper.map(atendimentos.inserir( atendimentoSaude), AtendimentoSaudeDTO.class);
		
		}catch(Exception e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public AtendimentoSaudeDTO atualizar(@PathVariable Long id, 
			@RequestBody @Valid AtendimentoSaudeInput input) {
		try {
			AtendimentoSaude atendimentoSaude = atendimentos.buscarEntidade(id);
			mapper.map(input, atendimentoSaude);
			
		return mapper.map(atendimentos.inserir(atendimentoSaude), AtendimentoSaudeDTO.class);
		
		}catch(Exception e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@GetMapping
	public List<AtendimentoSaudeDTO> listar(){
		return atendimentos
		.listarTodos().stream().map(t->mapper.map(t, AtendimentoSaudeDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public AtendimentoSaudeDTO Buscar(@PathVariable Long id) {
		return atendimentos.localizarEntidade(id);
	}
	
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		atendimentos.excluir(id);
	}
	


}
