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

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ParticipacaoInstituicaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.ParticipacaoInstituicaoInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.MoradorNaoEncontradoException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Morador;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.ParticipacaoInstituicao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ParticipacaoInstituicaoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;



@Api(tags = "Participação em Instituições")
@RestController
@RequestMapping("/participacao-instituicao")
public class ParticipacaoInstiticaoController {
	
	@Autowired
	ParticipacaoInstituicaoService pariticipacaoInstituicaoCadastro;
	@Autowired
	ModelMapper mapper;
	
	@CheckSecurity.Geral.PodeEditar
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ParticipacaoInstituicaoDTO adicionar(@RequestBody @Valid ParticipacaoInstituicaoInput pariticipacaoInstituicaoInput) {
		try {
			
			ParticipacaoInstituicao pariticipacaoInstituicao = mapper.map(pariticipacaoInstituicaoInput, ParticipacaoInstituicao.class);
			return mapper.map(pariticipacaoInstituicaoCadastro.inserir(pariticipacaoInstituicao), ParticipacaoInstituicaoDTO.class);
			
			}catch (MoradorNaoEncontradoException e){
				throw new 	EntidadeNaoEncontradaException(e.getMessage());			
			}
	}
	
	@CheckSecurity.Geral.PodeEditar
	@PutMapping("/{id}")
	public ParticipacaoInstituicaoDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid ParticipacaoInstituicaoInput pariticipacaoInstituicaoInput) {
		try {
			ParticipacaoInstituicao pariticipacaoInstituicaoAtual = pariticipacaoInstituicaoCadastro.buscarEntidade(id);
		pariticipacaoInstituicaoAtual.setMorador(new Morador());
		mapper.map(pariticipacaoInstituicaoInput, pariticipacaoInstituicaoAtual);
		return mapper.map(pariticipacaoInstituicaoCadastro.inserir(pariticipacaoInstituicaoAtual), ParticipacaoInstituicaoDTO.class);
		}catch (MoradorNaoEncontradoException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping
	public List<ParticipacaoInstituicaoDTO> listar(){
		return pariticipacaoInstituicaoCadastro
				.listarTodos().stream().map(t->mapper.map(t, ParticipacaoInstituicaoDTO.class)).toList();

	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/{id}")
	public ParticipacaoInstituicaoDTO Buscar(@PathVariable Long id) {
		return pariticipacaoInstituicaoCadastro.localizarEntidade(id);
	}
	
	@CheckSecurity.Geral.PodeConsultar
	@GetMapping("/morador-pariticipacao-instituicao/{moradorId}")
	public List<ParticipacaoInstituicaoDTO> buscarPorMorador(@PathVariable Long moradorId){
		return pariticipacaoInstituicaoCadastro.buscarPorMorador(moradorId);
	}
	
	@CheckSecurity.RestritoAdmin.ApenasAdmin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		pariticipacaoInstituicaoCadastro.excluir(id);
	}

}
