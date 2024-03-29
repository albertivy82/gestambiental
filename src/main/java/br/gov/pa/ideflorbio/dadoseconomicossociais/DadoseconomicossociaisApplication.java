package br.gov.pa.ideflorbio.dadoseconomicossociais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.gov.pa.ideflorbio.dadoseconomicossociais.core.io.Base64ProtocolResolver;


@SpringBootApplication
public class DadoseconomicossociaisApplication {

	public static void main(String[] args) {
		
		var app = new SpringApplication(DadoseconomicossociaisApplication.class);
		app.addListeners(new Base64ProtocolResolver());
		app.run(args);
		//SpringApplication.run(DadoseconomicossociaisApplication.class, args);
	}

}
