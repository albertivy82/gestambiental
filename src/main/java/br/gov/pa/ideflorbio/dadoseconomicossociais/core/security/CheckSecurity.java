package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {
	
	public @interface Usuario{
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_USUARIO')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {}
	}
	
	public @interface GerenciaLocalidade{
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_LOCALIDADE')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {}
		
		@PreAuthorize("hasAuthority('SCOPE_READ')and isAuthenticated()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
	}
	
	public @interface GereciaSocioeconomia{
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_DADOS_SOCIAIS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {}
		
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
	}
	
	public @interface GereciaAmbiental{
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_DADOS_AMBIENTAIS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {}
		
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
	}
	
	public @interface GereciaPermissao{
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('EDITAR_PERMISSOES')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeEditar {}
		
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {}
	}

}
