package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AlimentacaoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.BenfeitoriaService;



@RestController
@RequestMapping("/benfeitoria/{id}/alimentos")
public class BenfAlimController {

	@Autowired
	BenfeitoriaService benfeitoriaCadastro;
	
	@Autowired
	ModelMapper mapper;

	//@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<Long> listarIdsAlimentos(@PathVariable Long id){
		
		List<Long> listagemDeAlimentosIds = benfeitoriaCadastro.listaAlimentos(id);
				
		
		return listagemDeAlimentosIds;
	}
	
	
	@PutMapping("/{alimentoid}")
	public void vincularBenfeitoriaAlimento(@PathVariable Long id, @PathVariable Long alimentoid) {
		benfeitoriaCadastro.vincularAlimentos(id, alimentoid);		
	}
	
	@DeleteMapping("/{alimentoid}")
	public void desVincularBenfeitoriaAlimento(@PathVariable Long id, @PathVariable Long alimentoid) {
		benfeitoriaCadastro.desVincularAlimentos(id, alimentoid);		
	}
	
	
	
	
}
