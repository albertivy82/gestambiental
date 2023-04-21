package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.GrupoDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.GrupoService;



@RestController
@RequestMapping("/grupos/{id}/permissoes")
public class GrupoPermissaoController {

	@Autowired
	GrupoService grupoCadastro;

	@GetMapping
	public List<GrupoDTO> listar(@PathVariable Long id){
		
		//return localidadesCadastro.listarUsuarios(id);
		
		return null;
	}
	
	
	@PutMapping("/{idPermissao}")
	public void VincularGrupoPermissao(@PathVariable Long id, @PathVariable Long idPermissao) {
		grupoCadastro.VinculaPermissao(id, idPermissao);		
	}
	
	@DeleteMapping("/{idPermissao}")
	public void DesvincularGrupoPermissao(@PathVariable Long id, @PathVariable Long idPermissao) {
		grupoCadastro.DesvinculaPermissao(id, idPermissao);	
	}
	
	
}
