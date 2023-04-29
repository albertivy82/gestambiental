package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import lombok.Getter;

@Getter
public class AuthUser extends User{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String fullName;
	
	public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authorites) {
		super(usuario.getMatricula(), usuario.getSenha(), authorites);
		
		this.userId = usuario.getId();
		this.fullName = usuario.getNome();
	}
	
	
	
	
}
