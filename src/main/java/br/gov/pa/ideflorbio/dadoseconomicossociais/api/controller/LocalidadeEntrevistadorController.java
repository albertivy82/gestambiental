package br.gov.pa.ideflorbio.dadoseconomicossociais.api.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.pa.ideflorbio.dadoseconomicossociais.api.model.UsuarioDTO;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.service.LocalidadeService;
import io.swagger.annotations.Api;


@Api(tags = "LocalidadeXUsuario")
@RestController
@RequestMapping("/localidade/{id}/usuario")
public class LocalidadeEntrevistadorController {

	@Autowired
	LocalidadeService localidadesCadastro;

	@GetMapping
	public List<UsuarioDTO> listar(@PathVariable Long id){
		
		return localidadesCadastro.listarUsuarios(id);
	}
	
	@PutMapping("/{idEntrevistador}")
	public void associarLocalidadeEntrevistador(@PathVariable Long id, @PathVariable Long idUsuario) {
		localidadesCadastro.vincularUsuario(id, idUsuario);
	}
	
	@DeleteMapping("/{idEntrevistador}")
	public void desassociarLocalidadeEntrevistador(@PathVariable Long id, @PathVariable Long idUsuario) {
		localidadesCadastro.desvincularUsuario(id, idUsuario);
	}
	
	
}
