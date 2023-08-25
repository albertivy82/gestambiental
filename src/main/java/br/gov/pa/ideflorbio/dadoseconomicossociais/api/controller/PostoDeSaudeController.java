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
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.PostoDeSaudeDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.PostoDeSaudeInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.PostoDeSaude;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.PostoDeSaudeService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "posto")
@RestController
@RequestMapping("/posto-de-saude")
public class PostoDeSaudeController {
	
	@Autowired
	PostoDeSaudeService postoCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public PostoDeSaudeDTO adicionar(@RequestBody @Valid PostoDeSaudeInput postoInput) {
		try {
			
			PostoDeSaude posto = mapper.map(postoInput, PostoDeSaude.class);
			return mapper.map(postoCadastro.inserir(posto), PostoDeSaudeDTO.class);
			
			}catch (LocalidadeNaoEncontradaException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@PutMapping("/{id}")
	public PostoDeSaudeDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid PostoDeSaudeInput postoInput) {
		try {
			PostoDeSaude postoAtual = postoCadastro.buscarEntidade(id);
		postoAtual.setLocalidade(new Localidade());
		mapper.map(postoInput, postoAtual);
		return mapper.map(postoCadastro.inserir(postoAtual), PostoDeSaudeDTO.class);
		}catch (LocalidadeNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@GetMapping
	public List<PostoDeSaudeDTO> listar(){
		return postoCadastro
				.listarTodos().stream().map(t->mapper.map(t, PostoDeSaudeDTO.class)).toList();

	}
	
	@GetMapping("/{id}")
	public PostoDeSaudeDTO Buscar(@PathVariable Long id) {
		return postoCadastro.localizarEntidade(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		postoCadastro.excluir(id);
	}

}
