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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.MamiferosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.MamiferosInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntrevistadoNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Entrevistado;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Mamiferos;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.MamiferosService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "mamifero")
@RestController
@RequestMapping("/mamifero")
public class MamiferoController {
	
	@Autowired
	MamiferosService mamiferoCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public MamiferosDTO adicionar(@RequestBody @Valid MamiferosInput mamiferoInput) {
		try {
			
			Mamiferos mamifero = mapper.map(mamiferoInput, Mamiferos.class);
			return mapper.map(mamiferoCadastro.inserir(mamifero), MamiferosDTO.class);
			
			}catch (EntrevistadoNaoEncontradoException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public MamiferosDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid MamiferosInput mamiferoInput) {
		try {
			Mamiferos mamiferoAtual = mamiferoCadastro.buscarEntidade(id);
		mamiferoAtual.setEntrevistado(new Entrevistado());
		mapper.map(mamiferoInput, mamiferoAtual);
		return mapper.map(mamiferoCadastro.inserir(mamiferoAtual), MamiferosDTO.class);
		}catch (EntrevistadoNaoEncontradoException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<MamiferosDTO> listar(){
		return mamiferoCadastro
				.listarTodos().stream().map(t->mapper.map(t, MamiferosDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public MamiferosDTO Buscar(@PathVariable Long id) {
		return mamiferoCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/entrevistado-mamifero/{entrevistadoId}")
	public List<MamiferosDTO> buscarPorEntrevistado(@PathVariable Long entrevistadoId){
		return mamiferoCadastro.buscarPorEntrevistado(entrevistadoId);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		mamiferoCadastro.excluir(id);
	}

}
