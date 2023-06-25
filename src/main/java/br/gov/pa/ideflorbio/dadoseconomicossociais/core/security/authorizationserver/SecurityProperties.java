package br.gov.pa.ideflorbio.dadoseconomicossociais.core.security.authorizationserver;

import jakarta.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@Validated
//VER ESTE GESTAMBIENTAL NO PROPOERTIES
@ConfigurationProperties("gestambiental.auth")
public class SecurityProperties {
	
	@NotBlank
	private String poviderUrl;

}
