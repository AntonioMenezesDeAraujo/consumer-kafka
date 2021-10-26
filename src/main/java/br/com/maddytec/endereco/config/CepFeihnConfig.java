package br.com.maddytec.endereco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class CepFeihnConfig {

	@Value("${api.cep.username}")
	private String usuario;
	
	@Value("${api.cep.senha}")
	private String senha;
	
	private BasicAuthRequestInterceptor basicAuthRequestInterceptor;
	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(usuario, senha);
	}
	
	
}
