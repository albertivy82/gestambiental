package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.CoordenadaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.CoordenadaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Coordenada;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.CoordenadaService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "coordenada")
@RestController
@RequestMapping("/coordenada")
public class CoordenadaController {
	
	@Autowired
	CoordenadaService coordenadaCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public CoordenadaDTO adicionar(@RequestBody @Valid CoordenadaInput coordenadaInput) {
		try {
			
			Coordenada coordenada = mapper.map(coordenadaInput, Coordenada.class);
			return mapper.map(coordenadaCadastro.inserir(coordenada), CoordenadaDTO.class);
			
			}catch (LocalidadeNaoEncontradaException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@PutMapping("/{id}")
	public CoordenadaDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid CoordenadaInput coordenadaInput) {
		try {
		Coordenada coordenadaAtual = coordenadaCadastro.buscarEntidade(id);
		coordenadaAtual.setLocalidade(new Localidade());
		mapper.map(coordenadaInput, coordenadaAtual);
		return mapper.map(coordenadaCadastro.inserir(coordenadaAtual), CoordenadaDTO.class);
		}catch (LocalidadeNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
		
	@GetMapping("/{id}")
	public CoordenadaDTO Buscar(@PathVariable Long id) {
		    Coordenada coordenda = coordenadaCadastro.buscarEntidade(id);
		
		return mapper.map(coordenda, CoordenadaDTO.class);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		coordenadaCadastro.excluir(id);
	}

}
