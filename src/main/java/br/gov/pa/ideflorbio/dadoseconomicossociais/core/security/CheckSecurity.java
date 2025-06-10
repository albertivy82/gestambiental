package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {

    public @interface Geral {

        @PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated()")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('SCOPE_WRITE') and (hasRole('ADMINISTRADOR') or hasRole('USUARIO'))")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeEditar {}
    }

    public @interface RestritoAdmin {

        @PreAuthorize("hasAuthority('SCOPE_WRITE') and hasRole('ADMINISTRADOR')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface ApenasAdmin {}
    }
}
