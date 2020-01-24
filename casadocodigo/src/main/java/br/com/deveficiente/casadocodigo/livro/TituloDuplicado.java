package br.com.deveficiente.casadocodigo.livro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TituloDuplicado implements Validator {
	
	private LivroRepository livroRepository;

	public TituloDuplicado(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;
		
		Optional<Livro> tituloDuplicado = livroRepository.findByTitulo(form.getTitulo());
		if(tituloDuplicado.isPresent()) {
			errors.rejectValue("Titulo", null, "Titulo já existe.");
		}
	}
}
