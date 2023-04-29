package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		
		return new AuthUser(usuario, getAuthorities(usuario));
	}
	
	private Collection<GrantedAuthority> getAuthorities(Usuario usuario){
		return usuario.getGrupo().stream()
				.flatMap(grupo->grupo.getPermissoes().stream())
					.map(permissoes-> new SimpleGrantedAuthority(permissoes.getNome().toUpperCase()))
			   .collect(Collectors.toSet());
	}

}
