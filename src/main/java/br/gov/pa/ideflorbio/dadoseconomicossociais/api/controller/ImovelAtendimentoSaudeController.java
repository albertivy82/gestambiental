package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.AtendimentoSaudeDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.CheckSecurity;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.ImovelService;



@RestController
@RequestMapping("/imovel/{id}/atedimento-saude")
public class ImovelAtendimentoSaudeController {

	@Autowired
	ImovelService imovelCadastro;

	@CheckSecurity.Usuario.PodeEditar
	@GetMapping
	public List<AtendimentoSaudeDTO> listar(@PathVariable Long id){
		
		return imovelCadastro.listaAtendimentoSaude(id);
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@PutMapping("/{idServico}")
	public void VincularImovelAtendimentoSaude(@PathVariable Long id, @PathVariable Long idAtendiemento) {
		imovelCadastro.vincularAtendimentoSaude(id, idAtendiemento);		
	}
	
	@CheckSecurity.Usuario.PodeEditar
	@DeleteMapping("/{idPermissao}")
	public void DesvincularImovelAtendimentoSaude(@PathVariable Long id, @PathVariable Long idAtendiemento) {
		imovelCadastro.desvincularAtendimentoSaude(id, idAtendiemento);	
	}
	
	
}
