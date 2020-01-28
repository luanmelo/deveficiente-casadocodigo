package br.com.deveficiente.casadocodigo.livro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LivroInexistenteException extends IllegalArgumentException {

	private static final long serialVersionUID = -2973171407031239765L;

	public LivroInexistenteException(String msg) {
		super(msg);
	}
}
