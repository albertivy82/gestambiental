package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.Usuario;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.repository.UsuariosRepository;

@Configuration
public class AuthoizationServerConfig {
	
	    @Bean
	    @Order(Ordered.HIGHEST_PRECEDENCE)
	    public SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception {
	        
	    	OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
	                new OAuth2AuthorizationServerConfigurer();

	        RequestMatcher endpointsMatcher = authorizationServerConfigurer
	                .getEndpointsMatcher();

	        http.securityMatcher(endpointsMatcher)
	            .authorizeHttpRequests(authorize -> {
	                authorize.anyRequest().authenticated();
	            })
	            .csrf(csrf -> csrf.ignoringRequestMatchers(endpointsMatcher))
	            .formLogin(customizer -> customizer.loginPage("/login"))
	            .exceptionHandling(exceptions -> {
	                exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
	            })
	            .apply(authorizationServerConfigurer);

	        return http.formLogin(customizer -> customizer.loginPage("/login")).build();
	    }

	
	@Bean
	public AuthorizationServerSettings providerSettings(SecurityProperties properties) {
		return AuthorizationServerSettings.builder()
				.issuer(properties.getPoviderUrl())
				.build();
		
		//ver a classe SecuriyProperties e o arquivo de Properties
	}
	
	@Bean
	public RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder,
								JdbcOperations jdbcOperations) {
		
		JdbcRegisteredClientRepository repository = new JdbcRegisteredClientRepository(jdbcOperations);
		
		return repository;
	}
	
	@Bean
	public JWKSource<SecurityContext> jwkSouce(JwtKeyStoreProperties properties) throws Exception{
		char[] keyStorePass  = properties.getPassword().toCharArray();
		String keypairAlias = properties.getKeypairAlias();
		
		Resource jksLocation = properties.getJksLocation();
		InputStream inputStream = jksLocation.getInputStream();
		
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(inputStream, keyStorePass);
		
		RSAKey rsaKey = RSAKey.load(keyStore, keypairAlias, keyStorePass);
		
		return new ImmutableJWKSet<>(new JWKSet(rsaKey));
		
	}
	
	@Bean
	public OAuth2TokenCustomizer<JwtEncodingContext> 
					jwtCustomizer(UsuariosRepository usuarios){
		
		return context->{
			
				Authentication authentication = context.getPrincipal();
				if(authentication.getPrincipal() instanceof User) {
					
					User user = (User) authentication.getPrincipal();
					Usuario usuario = usuarios.findByMatricula(user.getUsername()).orElseThrow();
					
					Set<String> authorities = new HashSet<>();
					for(GrantedAuthority authority : user.getAuthorities()) {
						authorities.add(authority.getAuthority());
					}
				
					context.getClaims().claim("matrícula", usuario.getMatricula().toString());
					context.getClaims().claim("authorities", authorities);
				}
			
		};
		
	}

}
