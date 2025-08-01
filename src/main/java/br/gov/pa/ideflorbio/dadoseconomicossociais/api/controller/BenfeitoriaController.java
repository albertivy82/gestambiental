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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.BenfeitoriaDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.BenfeitoriaInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.ImovelNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Benfeitoria;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.BenfeitoriaService;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/benfeitoria")
public class BenfeitoriaController {
	
	@Autowired
	BenfeitoriaService benfeitoriaCad;
	
	@Autowired
	ModelMapper mapper;
	
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public BenfeitoriaDTO adicionar (@RequestBody @Valid BenfeitoriaInput benfeitoriaInput) {
		
		try {
			Benfeitoria benfeitoria = mapper.map(benfeitoriaInput, Benfeitoria.class);
			return mapper.map(benfeitoriaCad.inserir(benfeitoria), BenfeitoriaDTO.class);
		}catch (ImovelNaoEncontradoException e){
			throw new EntidadeNaoEncontradaException(e.getMessage());
			
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public BenfeitoriaDTO atualizar (@PathVariable Long id, @RequestBody @Valid BenfeitoriaInput benfeitoriaInput) {
		
		try {
			Benfeitoria benfeitoriaAtual = benfeitoriaCad.buscarEntidade(id);
			benfeitoriaAtual.setImovel(new Imovel());
			mapper.map(benfeitoriaInput, benfeitoriaAtual);
			return mapper.map(benfeitoriaCad.inserir(benfeitoriaAtual), BenfeitoriaDTO.class);
		}catch (ImovelNaoEncontradoException e){
			throw new EntidadeNaoEncontradaException(e.getMessage());
			
		}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/imovel-benfeitoria/{imovel}")
	public List<BenfeitoriaDTO> buscarPorImovel (@PathVariable Long imovel) {
		
			return benfeitoriaCad.buscarPorImovel(imovel)
					.stream().map(b->mapper.map(b,BenfeitoriaDTO.class)).toList();
		
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping
	public List<BenfeitoriaDTO> listar(){
		return benfeitoriaCad
				.listarTodos().stream().map(b->mapper.map(b, BenfeitoriaDTO.class)).toList();
	}
	
	@CheckSecurity.Geral.PodeEditar
	@GetMapping("/{id}")
	public BenfeitoriaDTO buscarPorId (@PathVariable Long id) {
		
		return mapper.map(benfeitoriaCad.buscarEntidade(id), BenfeitoriaDTO.class);
		
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		benfeitoriaCad.excluir(id);
	}
	
	


}
