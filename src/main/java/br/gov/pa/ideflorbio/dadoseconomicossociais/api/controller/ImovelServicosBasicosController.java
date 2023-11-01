package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.ServicosBasicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ImovelService;



@RestController
@RequestMapping("/imovel/{id}/servicos-basicos")
public class ImovelServicosBasicosController {

	@Autowired
	ImovelService imovelCadastro;

	@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<ServicosBasicosDTO> listar(@PathVariable Long id){
		
		return imovelCadastro.listaServicosBasicos(id);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{idServico}")
	public void VincularImovelServico(@PathVariable Long id, @PathVariable Long idServico) {
		imovelCadastro.vincularServicoBasico(id, idServico);		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{idPermissao}")
	public void DesvincularGrupoPermissao(@PathVariable Long id, @PathVariable Long idServico) {
		imovelCadastro.desvincularServicoBasico(id, idServico);	
	}
	
	
}
