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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ComprasDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.ComprasInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ResidenciaNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Compras;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ComprasService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "Dados de Compras")
@RestController
@RequestMapping("/compras")
public class ComprasController {
	
	
	@Autowired
	ComprasService ComprasCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ComprasDTO adicionar(@RequestBody @Valid ComprasInput comprasInput) {
		try{
			Compras compra = mapper.map(comprasInput, Compras.class);
			return mapper.map(ComprasCadastro.inserir(compra), ComprasDTO.class);
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ComprasDTO atualizar(@PathVariable Long id, 
			@RequestBody @Valid ComprasInput comprasInput) {
		try {
			Compras comprasAtual = ComprasCadastro.buscarEntidade(id);
			comprasAtual.setBenfeitoria(new Benfeitoria());
			mapper.map(comprasInput, comprasAtual);
			return mapper.map(ComprasCadastro.inserir(comprasAtual), ComprasDTO.class); 
			
		}catch(ResidenciaNaoEncontradaException e) {
			throw new EntidadeNaoEncontradaException(e.getMessage());
		}
		
	}
	
	
	@GetMapping
	public List<ComprasDTO> listar(){
		return ComprasCadastro
				.listarTodos().stream().map(t->mapper.map(t, ComprasDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public ComprasDTO Buscar(@PathVariable Long id) {
		return ComprasCadastro.localizarEntidade(id);
	}
	
	@GetMapping("local-de-compras-benfeitoria/{bftid}")
	public ComprasDTO BuscarLocalComprasBnfeioria(@PathVariable Long bftid) {
		Compras compra = ComprasCadastro.localDeComprasdaBenfeitoria(bftid);
		
		return mapper.map(compra, ComprasDTO.class);
	}
	
		
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		ComprasCadastro.excluir(id);
	}
	


}
