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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.DependenciasDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.DependenciasInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Dependencias;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.DependenciasService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/dependencias")
public class DependenciasController {
	
	@Autowired
	DependenciasService dependencias;
	
	@Autowired
	ModelMapper mapper;
	
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public DependenciasDTO adicionar (@RequestBody @Valid DependenciasInput dependenciaInput){
		
		try {
			Dependencias dependencia = mapper.map(dependenciaInput, Dependencias.class);
			return mapper.map(dependencias.inserir(dependencia), DependenciasDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public DependenciasDTO atualizar(@PathVariable Long id,
			@RequestBody @Valid DependenciasInput dependenciaInput) {
		
		try {
			Dependencias dependencia =  dependencias.buscarEntidade(id);
			dependencia.setBenfeitoria(new Benfeitoria());
			 mapper.map(dependenciaInput, dependencia);
			return mapper.map(dependencias.inserir(dependencia), DependenciasDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	
	@GetMapping
	public List<DependenciasDTO> listar(){
		return dependencias
				.listarTodos().stream().map(t->mapper.map(t, DependenciasDTO.class)).toList();
	}
	
	@GetMapping("/por-benfeitoria/{id}")
	public List<DependenciasDTO> DependenciasBnfeitoria(@PathVariable Long id){
		return dependencias
				.dependenciasdaBenfeitoria(id).stream().map(t->mapper.map(t, DependenciasDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public DependenciasDTO Buscar(@PathVariable Long id) {
		return mapper.map(dependencias.buscarEntidade(id), DependenciasDTO.class);
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		dependencias.excluir(id);
	}
	


}
	
	


