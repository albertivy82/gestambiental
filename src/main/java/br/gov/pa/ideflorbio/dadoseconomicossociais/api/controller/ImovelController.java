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
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ImovelDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.input.ImovelInput;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.EntidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.exceptions.LocalidadeNaoEncontradaException;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Imovel;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Localidade;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ImovelService;
import io.swagger.annotations.Api;



@Api(tags = "imovel")
@RestController
@RequestMapping("/imovel")
public class ImovelController {
	
	@Autowired
	ImovelService imoveisCadastro;
	
	@Autowired
	ModelMapper mapper;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public ImovelDTO adicionar(@RequestBody @Valid ImovelInput imovelInput) {
		try {
			
		Imovel imovel = mapper.map(imovelInput, Imovel.class);
		return mapper.map(imoveisCadastro.inserir(imovel), ImovelDTO.class);
		
		}catch (LocalidadeNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}
	
	@PutMapping("/{id}")
	public ImovelDTO atualizar(@PathVariable Long id, 
		@RequestBody @Valid ImovelInput imovelInput) {
		try {
		Imovel imovelAtual = imoveisCadastro.buscarEntidade(id);
		imovelAtual.setLocalidade(new Localidade());
		mapper.map(imovelInput, imovelAtual);
		return mapper.map(imoveisCadastro.inserir(imovelAtual), ImovelDTO.class);
		}catch (LocalidadeNaoEncontradaException e){
			throw new 	EntidadeNaoEncontradaException(e.getMessage());			
		}
	}

	@GetMapping
	public List<ImovelDTO> listar(){
		return imoveisCadastro
				.listarTodos().stream().map(t->mapper.map(t, ImovelDTO.class)).toList();
	}
	
	@GetMapping("/{id}")
	public ImovelDTO Buscar(@PathVariable Long id) {
		return imoveisCadastro.localizarEntidade(id);
	}
	
	@GetMapping("localidade-imovel/{idLocalidade}")
	public List<ImovelDTO> BuscarPoLocalidade(@PathVariable Long idLocalidade) {
		return imoveisCadastro.findByLocalidade(idLocalidade);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRegistro (@PathVariable Long id) {
		imoveisCadastro.excluir(id);
	}

}
