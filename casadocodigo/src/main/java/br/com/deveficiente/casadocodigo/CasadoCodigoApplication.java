package br.com.deveficiente.casadocodigo;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CasadoCodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadoCodigoApplication.class, args);
	}

	
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer(){
		return (factory) -> factory
				.addContextCustomizers((context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
	}
}
