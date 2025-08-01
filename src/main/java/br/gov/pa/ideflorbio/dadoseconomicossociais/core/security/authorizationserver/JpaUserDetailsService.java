package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.UsuariosRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByMatricula(matricula)
				.orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado coma matrícula informada"));
		
		return new User(usuario.getMatricula(), usuario.getSenha(), getAuthorities(usuario));
	}
	
	private Collection<GrantedAuthority> getAuthorities(Usuario usuario){
		
		Set<GrantedAuthority> authorities = usuario.getGrupo().getPermissoes().stream()
		        .map(permissao -> new SimpleGrantedAuthority(permissao.getNome().toUpperCase()))
		        .collect(Collectors.toSet());

		    // Adiciona a role do grupo (ex: ROLE_ADMINISTRADOR)
		    authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getGrupo().getNome().toUpperCase()));

		    return authorities;
	}

}
