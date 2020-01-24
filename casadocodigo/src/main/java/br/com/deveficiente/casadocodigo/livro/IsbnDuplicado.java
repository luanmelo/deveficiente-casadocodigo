package br.com.deveficiente.casadocodigo.livro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class IsbnDuplicado implements Validator {

	private LivroRepository livroRepository;

	public IsbnDuplicado(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;
		
		Optional<Livro> isbnDuplicado = livroRepository.findByIsbn(form.getIsbn());
		if(isbnDuplicado.isPresent()) {
			errors.rejectValue("isbn", null, "Isbn já existe.");
		}
	}

}
