package br.com.deveficiente.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CasadoCodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadoCodigoApplication.class, args);
	}

}
