package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;

import jakarta.validation.Valid;

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
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.EntrevistadoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.EntrevistadoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.EntrevistadoService;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.EntrevistadoService;
import io.swagger.annotations.Api;



@Api(tags = "entrevistado")
@RestController
@RequestMapping("/entrevistado")
public class EntrevistadoController {
	
	@Autowired
	EntrevistadoService entrevitadosCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public EntrevistadoDTO adicionar(@RequestBody @Valid EntrevistadoInput entrevistadoInput) {
		try {
			
		Entrevistado entrevistado = mapper.map(entrevistadoInput, Entrevistado.class);
		return mapper.map(entrevitadosCadastro.inserir(entrevistado), EntrevistadoDTO.class);
		
		}catch (LocalidadeNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@PutMapping("/{id}")
	public EntrevistadoDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid EntrevistadoInput entrevistadoInput) {
		try {
		Entrevistado entrevistadoAtual = entrevitadosCadastro.buscarEntidade(id);
		entrevistadoAtual.setLocalidade(new Localidade());
		mapper.map(entrevistadoInput, entrevistadoAtual);
		return mapper.map(entrevitadosCadastro.inserir(entrevistadoAtual), EntrevistadoDTO.class);
		}catch (LocalidadeNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}

	@GetMapping
	public List<EntrevistadoDTO> listar(){
		return entrevitadosCadastro
				.listarTodos().stream().map(t->mapper.map(t, EntrevistadoDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public EntrevistadoDTO Buscar(@PathVariable Long id) {
		return entrevitadosCadastro.localizarEntidade(id);
	}
	
	@GetMapping("localidade-entrevistado/{idLocalidade}")
	public List<EntrevistadoDTO> BuscarPoLocalidade(@PathVariable Long idLocalidade) {
		return entrevitadosCadastro.findByLocalidade(idLocalidade);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		entrevitadosCadastro.excluir(id);
	}

}
