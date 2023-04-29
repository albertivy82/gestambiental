package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class AuthoizationServerConfig {
	
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception{
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
		return http
				.formLogin(Customizer.withDefaults())
				.build();
	}
	
	@Bean
	public ProviderSettings providerSettings(SecurityProperties properties) {
		return ProviderSettings.builder()
				.issuer(properties.getPoviderUrl())
				.build();
	}
	
	@Bean
	public RegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder) {
		
		RegisteredClient gestambiental = RegisteredClient
				.withId("1")
				.clientId("gestambiental")
				.clientSecret(passwordEncoder.encode("abcdef"))
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.scope("READ")
				.scope("WRITE")
				.tokenSettings(TokenSettings.builder()
						.accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
						.accessTokenTimeToLive(java.time.Duration.ofMinutes(50))
						.build())
				.redirectUri("http://127.0.0.1:8080/authorized")
				.clientSettings(ClientSettings.builder()
						.requireAuthorizationConsent(false)
						.build())
				.build();
		
		return new InMemoryRegisteredClientRepository(Arrays.asList(gestambiental));
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

}
