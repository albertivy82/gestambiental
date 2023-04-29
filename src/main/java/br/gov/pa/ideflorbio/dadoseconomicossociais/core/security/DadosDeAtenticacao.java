package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

//para o resource pegar dados de atenticação
//mas é preciso criar o campo no banco
//bom para salvar quem fez uma operação

@Component
public class DadosDeAtenticacao {
	
	public Authentication getAthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public Long getUsuarioId() {
		
		Jwt jwt = (Jwt) getAthentication().getPrincipal();
		
		return jwt.getClaim("Usuario_id");
		
	}

}
