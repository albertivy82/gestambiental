package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.OutrosServicosDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ImovelService;



@RestController
@RequestMapping("/imovel/{id}/outros-servicos")
public class ImovelOutrosServicosController {

	@Autowired
	ImovelService imovelCadastro;

	@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<OutrosServicosDTO> listar(@PathVariable Long id){
		
		return imovelCadastro.listaOutrosServicos(id);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{idServico}")
	public void VincularImovelOutrosServicos(@PathVariable Long id, @PathVariable Long idServico) {
		imovelCadastro.vincularOutrosServicos(id, idServico);		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{idPermissao}")
	public void DesvincularImovelOutrosServicos(@PathVariable Long id, @PathVariable Long idServico) {
		imovelCadastro.desvincularOutrosServicos(id, idServico);	
	}
	
	
}
